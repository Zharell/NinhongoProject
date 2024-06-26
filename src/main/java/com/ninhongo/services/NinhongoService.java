package com.ninhongo.services;

import java.io.IOException;
import java.io.InputStream;

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

@Service
public class NinhongoService {
	
	private static final Logger log = LoggerFactory.getLogger(NinhongoService.class);
	
	//Todas las palabras
	private JMDictEntry dictWords;
	
	@Autowired
	ResourceLoader resourceLoader;
	
	//Al inicio de la APP se genera una palabra que pueda tener Kanji o no (Sin terminar)
	@PostConstruct
	public void init() throws IOException {
		ObjectMapper mapperJson = new ObjectMapper();
		Resource resource = resourceLoader.getResource("classpath:dictionaries/japondicc.json");
		
		try(InputStream inputStream = resource.getInputStream()) {
			dictWords = mapperJson.readValue(inputStream, new TypeReference<JMDictEntry>() {});
		} catch (Exception e) {
			log.info("Excepción localizada {}", e.getCause());
		}
		
	}
	
	//Retornamos la palabra del día
	public JMDictEntry getWordOfTheDay () {
		return dictWords;
	}
	
}
