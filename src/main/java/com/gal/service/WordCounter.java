package com.gal.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
@Service
public class WordCounter {

	public Map<String, Integer> getCount(String word) {
		Map<String, Integer> map = new LinkedHashMap<>();
		String[] a1 = word.split(",|\\s");
		int c = 1;
		for (String a2 : a1) {
			if (!map.containsKey(a2)) {
				map.put(a2, c);
				
			} else {
				map.put(a2, c + 1);
			}
		}
		
		return map;
	}
}
