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

	public Double volume(double length, double breadth, double height) {
		// TODO Auto-generated method stub
		Double x=length*breadth*height;
		
		return x;
	}

	public Double sum(Double variable1, Double variable2) {
		// TODO Auto-generated method stub
		
		Double totalSum=variable1+variable2;
		return totalSum;
	}

	public Double findCircleArea(Double radius) {
		// TODO Auto-generated method stub
		
		Double area = 3.14159*radius*radius;
		
		return area;
	}

	public Double findRectangleArea(Double width,Double height) {
		// TODO Auto-generated method stub
		Double area= width*height;
		
		
		return area;
	}
	public  String fmt(double d)
	{
	    if(d == (long) d)
	        return String.format("%d",(long)d);
	    else
	        return String.format("%s",d);
	}
		
}
