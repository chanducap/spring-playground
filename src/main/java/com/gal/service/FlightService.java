package com.gal.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gal.service.FlightService.Flight;

@Service
public class FlightService {

	public Flight getFlightDetails() {
		// TODO Auto-generated method stub
		Flight flight = new Flight();
		flight.setDeparts(new Date(2017-1900, 04, 21, 10, 34));
		List<Ticket> list = new ArrayList<>();
		Ticket t1 = new Ticket();
		Person passenger = new Person();
		passenger.setFistName("hi");
		passenger.setLastName("world");
		t1.setPrice("200");
		t1.setPassenger(passenger);
		list.add(t1);
		flight.setTickets(list);
		return flight;

	}

	public static class Flight {
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
		@JsonProperty("Departs")
		private Date departs;
		@JsonProperty("Tickets")
		private List<Ticket> tickets = Collections.emptyList();

		public Date getDeparts() {
			return departs;
		}

		public void setDeparts(Date departs) {
			this.departs = departs;
		}

		public List<Ticket> getTickets() {
			return tickets;
		}

		public void setTickets(List<Ticket> tickets) {
			this.tickets = tickets;
		}

	}

	static class Ticket {
		@JsonProperty("Passenger")
		private Person passenger;
		@JsonProperty("Price")
		private String price;

		public Person getPassenger() {
			return passenger;
		}

		public void setPassenger(Person passenger) {
			this.passenger = passenger;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}
	}
	@JsonInclude(JsonInclude.Include.NON_NULL)
	static class Person {
		@JsonProperty("FirstName")
		private String fistName;
		@JsonProperty("LastName")
		private String lastName;

		public String getFistName() {
			return fistName;
		}

		public void setFistName(String fistName) {
			this.fistName = fistName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	}

	public List<Flight> getallFlightDetails() {
		// TODO Auto-generated method stub
		Flight flight1 = new Flight();
		flight1.setDeparts(new Date(2017-1900, 04, 11, 10, 34));
		List<Ticket> list = new ArrayList<>();
		Ticket t1 = new Ticket();
		Person passenger = new Person();
		passenger.setFistName("God");
		passenger.setLastName("Is Great");
		t1.setPrice("200");
		t1.setPassenger(passenger);
		list.add(t1);
		flight1.setTickets(list);

		Flight flight2 = new Flight();
		flight2.setDeparts(new Date(2017-1900, 04, 01, 10, 34));
		List<Ticket> list1 = new ArrayList<>();
		Ticket t2 = new Ticket();
		Person passenger2 = new Person();
		passenger2.setFistName("hi");
		passenger2.setLastName("world");
		t1.setPrice("100");
		t1.setPassenger(passenger2);
		list1.add(t2);
		flight2.setTickets(list);
		return Arrays.asList(flight1, flight2);

	}

}
