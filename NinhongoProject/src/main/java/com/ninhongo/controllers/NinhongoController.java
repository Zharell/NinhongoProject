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
@RequestMapping("/v1")
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
	@GetMapping("/kotd")
	public ResponseEntity<JMDictEntry> getKanjiOfTheDay() {
		return ResponseEntity.ok(ninhongoService.getKanjiOfTheDay());
	}
	
	//Devolvemos un kanji aleatorio
	@GetMapping("/rkanji")
	public ResponseEntity<JMDictEntry> getRandomKanji() {
		return ResponseEntity.ok(ninhongoService.getRandomKanji());
	}
	
	//Devolvemos una palabra que no sea kanji del día
	@GetMapping("/nkotd")
	public ResponseEntity<JMDictEntry> getKanaOfTheDay() {
		return ResponseEntity.ok(ninhongoService.getKanaOfTheDay());
	}
	
	//Devolvemos una palabra aleatoria
	@GetMapping("/rnkanji")
	public ResponseEntity<JMDictEntry> getRandomKana() {
		return ResponseEntity.ok(ninhongoService.getRandomKana());
	}
	
}
