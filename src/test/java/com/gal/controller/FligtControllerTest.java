package com.gal.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(FlightController.class)
public class FligtControllerTest {
	
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
	        this.mvc.perform(
	                get("/flights/flight")
	                        .accept(MediaType.APPLICATION_JSON_UTF8)
	                        .contentType(MediaType.APPLICATION_JSON_UTF8))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.Departs", is("2017-05-21 14:34")))
	                .andExpect(jsonPath("$.Tickets[0].Passenger.FirstName", is("hi")))
	                .andExpect(jsonPath("$.Tickets[0].Passenger.LastName", is("world")))
	                .andExpect(jsonPath("$.Tickets[0].Price", is("200")))
	                ;
	        
	    }

	    @Test
	    public void testArray() throws Exception {
	        this.mvc.perform(
	                get("/flights")
	                        .accept(MediaType.APPLICATION_JSON_UTF8)
	                        .contentType(MediaType.APPLICATION_JSON_UTF8))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$[0].Departs", is("2017-05-11 14:34")))
	                .andExpect(jsonPath("$[0].Tickets[0].Passenger.FirstName", is("hi")))
	                .andExpect(jsonPath("$[0].Tickets[0].Passenger.LastName", is("world")))
	                .andExpect(jsonPath("$[0].Tickets[0].Price", is("100")))
	                .andExpect(jsonPath("$[1].Departs", is("2017-05-01 14:34")))
	                .andExpect(jsonPath("$[1].Tickets[0].Passenger.FirstName", is("hi")))
	                .andExpect(jsonPath("$[1].Tickets[0].Passenger.LastName", is("world")))
	                .andExpect(jsonPath("$[1].Tickets[0].Price", is("100")))
	                ;
	        
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	  
}
