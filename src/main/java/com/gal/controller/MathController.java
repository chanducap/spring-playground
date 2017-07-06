package com.gal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gal.service.MathService;

@RestController
@RequestMapping("/math")
public class MathController {

	@Autowired
	private MathService mathservice;
	@GetMapping("/calculate")
	public Double sum(@RequestParam(required = true, value = "x") Double variable1,
			@RequestParam(required = true, value = "y") Double variable2,
			@RequestParam(required = true, value = "operation") String opera) {

		Double var;
		switch (opera) {
		case "add":
			var = mathservice.sum(variable1, variable2);
			break;
		case "multiply":
			var = mathservice.mul(variable1, variable2);
			break;
		case "subtract":
			var = mathservice.sub(variable1, variable2);
			break;
		case "divide":
			var = mathservice.divide(variable1, variable2);
			break;
		default:
			var = 0.0;
			break;
		}
		return var;
	}

	@PostMapping("/sum")
	public Integer Sum(@RequestParam(value = "n") List<Integer> count) {

		Integer sumValue = mathservice.findSum(count);
		return sumValue;
	}

}
