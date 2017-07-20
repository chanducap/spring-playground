package com.gal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gal.service.FlightService;
import com.gal.service.FlightService.Flight;
import com.gal.service.FlightService.FlightSum;
import com.gal.service.FlightService.Response;

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
	
	@PostMapping(value="/flights/tickets/total",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getFlightTicketSum(@RequestBody FlightSum flightSum) {
		System.out.println(flightSum.getTickets().get(0));
		Response flightTicketSum = service.getFlightTicketPrice(flightSum);
			return flightTicketSum;
	
	}
//FlightSum flightTicketSum = service.getFlightTicket();
//return flightTicketSum;
//	FlightSum flightTicketSum = service.getFlightTicket();
	

}
