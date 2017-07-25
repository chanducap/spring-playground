package com.gal.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gal.service.WordCounter;

@RestController
@RequestMapping(value = "/words", consumes = MediaType.ALL_VALUE)
public class WordCounterController {

	public final WordCounter counter;
	public WordCounterController(WordCounter counter){
		this.counter=counter;
	}
	
	
@PostMapping("/count")
public Map<String,Integer> getCount(@RequestBody String str){
	
	Map<String,Integer>	returnMap= counter.getCount(str);
	return returnMap;
	
}

	
	
}
