package com.gal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gal.service.MathService;
import com.gal.vo.AreaObject;

@RestController
@RequestMapping(value = "/math", consumes = MediaType.ALL_VALUE)
public class MathController {

	public static final String SHAPE_CIRCLE = "circle";
	public static final String SHAPE_RECTANGLE = "rectangle";

	@Autowired
	private MathService mathservice;

	@GetMapping("/calculate")
	public String sum(@RequestParam(required = true, value = "x") Double variable1,
			@RequestParam(required = true, value = "y") Double variable2,
			@RequestParam(required = true, value = "operation", defaultValue = "sum") String opera) {

		Double var;
		switch (opera) {
		case "add":
			var = mathservice.add(variable1, variable2);
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
			var = mathservice.sum(variable1, variable2);
			break;
		}
		return Double.toString(var);
	}

	@PostMapping("/sum")
	public String Sum(@RequestParam(value = "n") List<Double> count) {

		Double sumValue = mathservice.findSum(count);
		return Double.toString(sumValue);
	}

	@PostMapping("/volume/{var1}/{var2}/{var3}")
	public String getVolume(@PathVariable double var1, @PathVariable double var2, @PathVariable double var3) {
		System.out.println(var1);
		String length=mathservice.fmt(var1);
		String width=mathservice.fmt(var2);
		String height=mathservice.fmt(var3);
		
		
		return String.format("The volume of a %s x %s x %s rectangle is  %s", length, width, height,
				Double.toString(mathservice.volume(var1, var2, var3)));
	}

	@PostMapping(value = "/area" /*consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE*/)
	public String findAreaCircleRectangle(@RequestBody AreaObject area) {

		if (area.getType().equalsIgnoreCase(SHAPE_CIRCLE) && !StringUtils.isEmpty(area.getRadius())) {
			Double Area = mathservice.findCircleArea(area.getRadius());
			String CircleRadius = mathservice.fmt(area.getRadius());
			return String.format("Area of a circle with a radius of  %s is %s", CircleRadius, Double.toString(Area));
		} else if (area.getType().equalsIgnoreCase(SHAPE_RECTANGLE) && !StringUtils.isEmpty(area.getWidth())
				&& !StringUtils.isEmpty(area.getHeight())) {
			Double Area = mathservice.findRectangleArea(area.getWidth(), area.getHeight());

			return String.format("Area of a  %s x %s rectangle is %s", mathservice.fmt(area.getWidth()),
					mathservice.fmt(area.getHeight()), Double.toString(Area));
		} else {
			return "Invalid Request";

		}
	}
}
