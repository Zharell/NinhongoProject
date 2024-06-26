package com.ninhongo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninhongo.entities.jmdicmodel.JMDictEntry;
import com.ninhongo.services.NinhongoService;

@RestController
@RequestMapping("/api/v1/wordofday")
public class NinhongoController {

	@Autowired
	private NinhongoService ninhongoService;
	
	@GetMapping
	public ResponseEntity<JMDictEntry> getWordOfTheDay() {
		return ResponseEntity.ok(ninhongoService.getWordOfTheDay());
	}
	
	
}
