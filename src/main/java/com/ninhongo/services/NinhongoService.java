package com.ninhongo.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ninhongo.entities.jmdicmodel.JMDictEntry;
import com.ninhongo.entities.jmdicmodel.JMDictWords;

@Service
public class NinhongoService {
	
	private final int ID_INICIO = 1000000;
	private final int ID_FINAL = 5746848;
	
	private static final Logger log = LoggerFactory.getLogger(NinhongoService.class);
	
	//Todas las palabras y maps
	private JMDictWords dictAllWords;
	private ArrayList <JMDictEntry> allWordList;
	private ConcurrentMap <String, JMDictEntry> wordMapId;
	private ConcurrentMap <String, JMDictEntry> wordMapKanji;
	private ConcurrentMap <String, JMDictEntry> wordMapKana;
	private ConcurrentMap <Integer, String> randomMapId;
	
	@Autowired
	ResourceLoader resourceLoader;
	
	//1301940
	//Al inicio de la APP se genera una palabra que pueda tener Kanji o no (Sin terminar)
	@PostConstruct
	public void init() throws IOException {
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
			wordMapId = new ConcurrentHashMap();
			wordMapKanji = new ConcurrentHashMap();
			wordMapKana = new ConcurrentHashMap();
			randomMapId = new ConcurrentHashMap();
			//Realizamos validaciones en caso de que esté un registro null o vacío
			int countId = 0;
			for (JMDictEntry entry : allWordList) {
				
				//Obtenemos valores utilizables para los IDs
				if (entry.getId() != null && !entry.getId().isEmpty()) {
					countId++;
					wordMapId.put(entry.getId(), entry);
					randomMapId.put(countId, entry.getId());
				}
				
				if (entry.getKanjiDicc() != null && !entry.getKanjiDicc().isEmpty()) {
					wordMapKanji.put(entry.getKanjiDicc().get(0).getText(), entry);
				}
				
				if (entry.getKanaDicc() != null && !entry.getKanaDicc().isEmpty()) {
					wordMapKana.put(entry.getKanaDicc().get(0).getText(), entry);
				}
				
			}
			
		}  catch (IOException e) {
            System.err.println("Error al cargar el diccionario: " + e.getMessage());
            e.printStackTrace();
        }
		
	}
	
	//Retornamos la palabra del día
	public JMDictEntry getWordOfTheDay () {
		int valorRandom = (int) (Math.random() * allWordList.size() + 1);
		return wordMapId.get(randomMapId.get(valorRandom));
	}
	
}
