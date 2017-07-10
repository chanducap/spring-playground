package com.gal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gal.service.MathService;

@RestController
@RequestMapping(value = "/math", consumes = MediaType.ALL_VALUE)
public class MathController {

	@Autowired
	private MathService mathservice;

	@GetMapping("/calculate")
	public String sum(@RequestParam(required = true, value = "x") Double variable1,
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
		return Double.toString(var);
	}

	@PostMapping("/sum")
	public String Sum(@RequestParam(value = "n") List<Double> count) {

		Double sumValue = mathservice.findSum(count);
		return Double.toString(sumValue);
	}

}
