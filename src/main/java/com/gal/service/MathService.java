package com.gal.service;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class MathService {

	public Double sum(Double variable1, Double variable2) {
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

	public Integer findSum(List<Integer> count) {
		// TODO Auto-generated method stub

		int sum = 0;
		for (Integer i : count) {
			sum = sum + i;
		}

		return sum;

	}
}
