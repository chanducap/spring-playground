package com.gal.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gal.service.FlightService.FlightSum;
import com.gal.service.FlightService.Person;
import com.gal.service.FlightService.Ticket;

@RunWith(SpringRunner.class)
@WebMvcTest(FlightController.class)
public class FlightControllerTest {
	@Autowired
	private WebApplicationContext ctx;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper mapper;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Autowired
	private MockMvc mvc;

	@Test
	public void testObject() throws Exception {
		this.mvc.perform(get("/flights/flight").accept(MediaType.APPLICATION_JSON_UTF8)
				.contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
				.andExpect(jsonPath("$.Departs", is("2017-05-21 14:34")))
				.andExpect(jsonPath("$.Tickets[0].Passenger.FirstName", is("hi")))
				.andExpect(jsonPath("$.Tickets[0].Passenger.LastName", is("world")))
				.andExpect(jsonPath("$.Tickets[0].Price", is("200")));

	}

	@Test
	public void testArray() throws Exception {
		this.mvc.perform(
				get("/flights").accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(jsonPath("$[0].Departs", is("2017-05-11 14:34")))
				.andExpect(jsonPath("$[0].Tickets[0].Passenger.FirstName", is("hi")))
				.andExpect(jsonPath("$[0].Tickets[0].Passenger.LastName", is("world")))
				.andExpect(jsonPath("$[0].Tickets[0].Price", is("100")))
				.andExpect(jsonPath("$[1].Departs", is("2017-05-01 14:34")))
				.andExpect(jsonPath("$[1].Tickets[0].Passenger.FirstName", is("hi")))
				.andExpect(jsonPath("$[1].Tickets[0].Passenger.LastName", is("world")))
				.andExpect(jsonPath("$[1].Tickets[0].Price", is("100")));

	}

	@Test
	public void testObjectParams() throws Exception {
		MockHttpServletRequestBuilder request = post("/flights/tickets/total").contentType(MediaType.APPLICATION_JSON)
				.content(
						"{ \"tickets\": [ { \"Passenger\": { \"FirstName\": \"Some name\", \"LastName\": \"Some other name\" }, \"Price\": 200 }, { \"Passenger\": { \"FirstName\": \"Name B\", \"LastName\": \"Name C\" }, \"Price\": 150 } ] }");

		this.mvc.perform(request).andExpect(status().isOk()).andExpect(content().string("{\"price\":\"350\"}"));
	}

	ObjectMapper objectMapper = new ObjectMapper(); // 1

	@Test
	public void testJackson() throws Exception {
		FlightSum f1 = new FlightSum();
		List<Ticket> a1 = new ArrayList<>();
		Ticket t1 = new Ticket();
		Person p1 = new Person();
		p1.setFistName("hi");
		p1.setLastName("world");
		t1.setPassenger(p1);
		t1.setPrice("150");
		a1.add(t1);
		f1.setTickets(a1);
		Ticket t2 = new Ticket();
		Person p2 = new Person();
		p2.setFistName("hi");
		p2.setLastName("God");
		t2.setPassenger(p2);
		t2.setPrice("200");
		a1.add(t2);
		f1.setTickets(a1);
		String json = objectMapper.writeValueAsString(f1); // 3
		MockHttpServletRequestBuilder request = post("/flights/tickets/total").contentType(MediaType.APPLICATION_JSON)
				.content(json); // 4
		this.mvc.perform(request).andExpect(status().isOk());
	}

	@Test
	public void testingBody() throws Exception {
		String json = getJSON("src/test/resources/data.json");
		System.out.println(json);
		MockHttpServletRequestBuilder request = post("/flights/tickets/total").contentType(MediaType.APPLICATION_JSON)
				.content(json);
		this.mvc.perform(request).andExpect(status().isOk()).andExpect(content().string("{\"price\":\"350\"}"));
	}

	private String getJSON(String path) throws Exception {
		ClassLoader classLoader = getClass().getClassLoader();
		System.out.println("PATH" + path);
		// File file = new File(classLoader.getResource(path).getFile());
		/*
		 * System.out.println("Path"+path); URL url =
		 * this.getClass().getResource(path); System.out.println("URL"+url);
		 * 
		 */ return new String(Files.readAllBytes(Paths.get(path)));

	}

}
