package com.gal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gal.service.FlightService;
import com.gal.service.FlightService.Flight;

@RestController
@RequestMapping(value = "/")
public class FlightController {
	@Autowired
	private FlightService service;
	@GetMapping("flights/flight")
	public Flight getFlight() {
		Flight flightInfo = service.getFlightDetails();
		return flightInfo;
	}

	@GetMapping("/flights")
	public List<Flight> getFlightsInfo() {
		List<Flight> flightInfo = service.getallFlightDetails();
		return flightInfo;
	}

}
