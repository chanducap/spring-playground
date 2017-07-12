package com.gal.service;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class MathService {

	public Double add(Double variable1, Double variable2) {
		// TODO Auto-generated method stub
		Double var = variable1 + variable2;
		return var;
	}

	public Double mul(Double variable1, Double variable2) {
		// TODO Auto-generated method stub
		Double var = variable1 * variable2;
		return var;
	}

	public Double sub(Double variable1, Double variable2) {
		// TODO Auto-generated method stub

		Double var = variable1 - variable2;
		return var;
	}

	public Double divide(Double variable1, Double variable2) {
		// TODO Auto-generated method stub
		Double var;
		if (variable2 != 0) {
			var = variable1 / variable2;
		} else {
			return null;
		}
		return var;
	}

	public Double findSum(List<Double> count) {
		// TODO Auto-generated method stub

		Double sum = 0.0;
		for (Double i : count) {
			sum = sum + i;
		}

		return sum;

	}

	public Double volume(Double length, Double breadth, Double height) {
		// TODO Auto-generated method stub
		Double volume=length*breadth*height;
		
		return volume;
	}

	public Double sum(Double variable1, Double variable2) {
		// TODO Auto-generated method stub
		
		Double totalSum=variable1+variable2;
		return totalSum;
	}
		
}
