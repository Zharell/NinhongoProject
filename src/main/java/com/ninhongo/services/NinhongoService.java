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
import com.ninhongo.entities.jmdicmodel.JMDictWords;

@Service
public class NinhongoService {
	
	private static final Logger log = LoggerFactory.getLogger(NinhongoService.class);
	
	//Todas las palabras
	private JMDictWords dictAllWords;
	
	@Autowired
	ResourceLoader resourceLoader;
	
	//Al inicio de la APP se genera una palabra que pueda tener Kanji o no (Sin terminar)
	@PostConstruct
	public void init() throws IOException {
		ObjectMapper mapperJson = new ObjectMapper();
		Resource resource = resourceLoader.getResource("classpath:dictionaries/WordList.json");
		
		try(InputStream inputStream = resource.getInputStream()) {
			dictAllWords = mapperJson.readValue(inputStream, new TypeReference<JMDictWords>() {});
		} 
		
	}
	
	//Retornamos la palabra del día
	public JMDictEntry getWordOfTheDay () {
		return dictAllWords.getJmDictWords().get(100000);
	}
	
}
