package com.ninhongo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninhongo.entities.jmdicmodel.JMDictEntry;
import com.ninhongo.entities.jmdicmodel.JMDictWords;
import com.ninhongo.services.NinhongoService;

@RestController
@RequestMapping("/api/v1")
public class NinhongoController {

	@Autowired
	private NinhongoService ninhongoService;
	
	//Devolvemos la palabra del día
	@GetMapping("/wotd")
	public ResponseEntity<JMDictEntry> getWordOfTheDay() {
		return ResponseEntity.ok(ninhongoService.getWordOfTheDay());
	}
	
	//Devolvemos una palabra aleatoria
	@GetMapping("/rword")
	public ResponseEntity<JMDictEntry> getRandomWord() {
		return ResponseEntity.ok(ninhongoService.getRandomWord());
	}
	
	//Devolvemos el kanji del día
	@GetMapping("/wotk")
	public ResponseEntity<JMDictEntry> getKanjiOfTheDay() {
		return ResponseEntity.ok(ninhongoService.getKanjiOfTheDay());
	}
	
	//Devolvemos un kanji aleatorio
	@GetMapping("/rwotk")
	public ResponseEntity<JMDictEntry> getRandomKanji() {
		return ResponseEntity.ok(ninhongoService.getRandomKanji());
	}
	
}
