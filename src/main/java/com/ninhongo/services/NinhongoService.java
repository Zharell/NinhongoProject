package com.ninhongo.services;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ninhongo.entities.jmdicmodel.JMDictEntry;
import com.ninhongo.entities.jmdicmodel.JMDictWords;

@Service
public class NinhongoService {
	
	private static final Logger log = LoggerFactory.getLogger(NinhongoService.class);
	
	//Todas las palabras y maps
	private JMDictWords dictAllWords;
	private ArrayList <JMDictEntry> allWordList;
	private ConcurrentMap <String, JMDictEntry> wordMapId;
	private ConcurrentMap <String, JMDictEntry> wordMapKanji;
	private ConcurrentMap <String, JMDictEntry> wordMapKana;
	
	//Variables Map encargadas de almacenar IDs correctos para evitar nulos e incongruencias
	private ConcurrentMap <Integer, String> randomWordId;
	private ConcurrentMap <Integer, String> randomKanjiId;
	
	//Ids concretos de la palabra o Kanji del día
	private int idWordOfTheDay;
	private int idKanjiOfTheDay;
	
	@Autowired
	ResourceLoader resourceLoader;
	
	@PostConstruct
	public void init() throws IOException {
		
		//Llamamos al método que lee el JSON y rellena los Maps
		generatedWordOfTheDay();
		
	}
	
	// Lee los datos del JSON y asigna valores a los distintos Maps y ArrayList
	public void generatedWordOfTheDay() {
		
		ObjectMapper mapperJson = new ObjectMapper();
		Resource resource = resourceLoader.getResource("classpath:dictionaries/WordList.json");
		
		try(InputStream inputStream = resource.getInputStream()) {
			
			//Obtenemos todas las palabras y 
			dictAllWords = mapperJson.readValue(inputStream, new TypeReference<JMDictWords>() {});
			allWordList = new ArrayList<JMDictEntry>(dictAllWords.getJmDictWords());
			
			/*
			Utilizamos hashmap y le añadimos valor para optimizar búsquedas en futuras peticiones
				id = almacenamos id
				kanji = almacenamos Kanji (String)
				kana = almacenamos kana (String)
				sense = almacenamos sense (Object Sensedicc)
			*/
			wordMapId = new ConcurrentHashMap<String, JMDictEntry>();
			wordMapKanji = new ConcurrentHashMap<String, JMDictEntry>();
			wordMapKana = new ConcurrentHashMap<String, JMDictEntry>();
			randomWordId = new ConcurrentHashMap<Integer, String>();
			randomKanjiId = new ConcurrentHashMap<Integer, String>();
			//Realizamos validaciones en caso de que esté un registro null o vacío
			int countIdWord = 0;
			int countIdKanji = 0;
			for (JMDictEntry entry : allWordList) {
				
				//Obtenemos todas las palabras y valores utilizables para los IDs
				if (entry.getId() != null && !entry.getId().isEmpty()) {
					countIdWord++;
					wordMapId.put(entry.getId(), entry);
					
					//Obtenemos IDs utilizables
					randomWordId.put(countIdWord, entry.getId());
					
				}
				
				//Obenemos todos los kanjis y sus valores utilizables para los IDs
				if (entry.getKanjiDicc() != null && !entry.getKanjiDicc().isEmpty()) {
					wordMapKanji.put(entry.getKanjiDicc().get(0).getText(), entry);
					
					//Obtenemos los IDs de solo los kanji
					if (entry.getKanjiDicc().size() != 0) {
						countIdKanji++;
						randomKanjiId.put(countIdKanji, entry.getId());
					}
					
				}
				
				if (entry.getKanaDicc() != null && !entry.getKanaDicc().isEmpty()) {
					wordMapKana.put(entry.getKanaDicc().get(0).getText(), entry);
				}
				
			}
			
			//Generamos el ID random a devolver
			generatedRandomIdOfTheDay();
			
		}  catch (IOException e) {
            System.err.println("Error al cargar el diccionario: " + e.getMessage());
            e.printStackTrace();
        }
	}
	
	
	//Creamos el método para programar la tarea utilizando scheduled, este provocará un cambio de ID al día
	@Scheduled(cron = "0 0 4 * * ?")
	public void scheduledJsonRead() {
		LocalTime now = LocalTime.now();
		log.info("Inicio de cambio de palabra del día: {}", now.toString());
		
		generatedWordOfTheDay();
		
		now = LocalTime.now();
		log.info("Finalizado cambio de palabra del día: {}", now.toString());
		
	}
	
	public void generatedRandomIdOfTheDay() {
		idWordOfTheDay = (int) (Math.random() * randomWordId.size() + 1);
		idKanjiOfTheDay = (int) (Math.random() * randomKanjiId.size() + 1);
	}
	
	//Retornamos la palabra del día
	public JMDictEntry getWordOfTheDay () {
		return wordMapId.get(randomWordId.get(idWordOfTheDay));
	}
	
	//Retornamos el kanji del día
	public JMDictEntry getKanjiOfTheDay() {
		return wordMapId.get(randomKanjiId.get(idKanjiOfTheDay));
	}
	
	//Retornamos una palabra aleatoria
	public JMDictEntry getRandomWord() {
		int randomId = (int) (Math.random() * randomWordId.size() + 1);
		return wordMapId.get(randomWordId.get(randomId));
	}
	
	//Retornamos un kanji aleatorio
	public JMDictEntry getRandomKanji() {
		int randomId = (int) (Math.random() * randomKanjiId.size() + 1);
		return wordMapId.get(randomKanjiId.get(randomId));
	}
	
}
