package com.gal.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)
public class MathControllerTest {

	@Autowired
	private WebApplicationContext ctx;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testAddEndpoint() throws Exception {
		this.mockMvc
				.perform(get("/math/calculate?operation={opera}&x={var1}&y={var2}", "add", 1.0, 2.0)
						.accept(MediaType.TEXT_PLAIN_VALUE))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().string("3.0"));

		this.mockMvc
				.perform(get("/math/calculate?operation={opera}&x={var1}&y={var2}", "multiply", 3.0, 2.0)
						.accept(MediaType.TEXT_PLAIN_VALUE))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().string("6.0"));

		this.mockMvc
				.perform(get("/math/calculate?operation={opera}&x={var1}&y={var2}", "subtract", 3.0, 2.0)
						.accept(MediaType.TEXT_PLAIN_VALUE))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().string("1.0"));

		this.mockMvc
				.perform(get("/math/calculate?operation={opera}&x={var1}&y={var2}", "divide", 6.0, 2.0)
						.accept(MediaType.TEXT_PLAIN_VALUE))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().string("3.0"));
		
	this.mockMvc
		.perform(post("/math/sum?n={var1}&n={var2}&n={var3}", 1.0, 6.0, 2.0)
				.accept(MediaType.TEXT_PLAIN_VALUE))
		.andDo(print()).andExpect(status().isOk()).andExpect(content().string("9.0"));		
		
	

	}

}