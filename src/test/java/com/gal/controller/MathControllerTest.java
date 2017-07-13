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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gal.vo.AreaObject;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)
public class MathControllerTest {
	private static final int length = 4;
	private static final int width = 5;
	private static final int height = 6;
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
				.perform(post("/math/sum?n={var1}&n={var2}&n={var3}", 1.0, 6.0, 2.0).accept(MediaType.TEXT_PLAIN_VALUE))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().string("9.0"));

		this.mockMvc.perform(get("/math/calculate?x={var1}&y={var2}", 6.0, 2.0).accept(MediaType.TEXT_PLAIN_VALUE))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().string("8.0"));
		
		 this.mockMvc .perform(post("/math/volume/{var1}/{var2}/{var3}", 2.0,
		 3.0, 2.0) .accept(MediaType.TEXT_PLAIN_VALUE))
		.andDo(print()).andExpect(status().isOk()) .andExpect(content().
		string("The volume of a 2 x 3 x 2 rectangle is  12.0"));
		
	}

	@Test
	public void findAreaCircleRectangle() throws Exception {
			
		AreaObject CircleRec = new AreaObject();//I am creating the object and binding the values for it.
		CircleRec.setType("circle");
		CircleRec.setRadius(4.0);
		CircleRec.setHeight(2.0);
		CircleRec.setWidth(2.0);
		String json = mapper.writeValueAsString(CircleRec);
		System.out.println(json);
		this.mockMvc.perform(post("/math/area")
				.param("type", "circle")
				.param("radius", "4.0")
				.contentType(MediaType.ALL_VALUE).accept(MediaType.ALL_VALUE))//I am getting the null pointer exception when i invoke this url.
				.andExpect(status().isOk()).andExpect(content().string("Area of a circle with a radius of  4 is 50.26544"));
	
	
	this.mockMvc.perform(post("/math/area")
			.param("type", "rectangle")
			.param("width", "4.0")
			.param("height", "3.0")
			.contentType(MediaType.ALL_VALUE).accept(MediaType.ALL_VALUE))//I am getting the null pointer exception when i invoke this url.
			.andExpect(status().isOk()).andExpect(content().string("Area of a  4 x 3 rectangle is 12.0"));
	
	this.mockMvc.perform(post("/math/area")
			.param("type", "circle")
			.param("width", "4.0")
			.param("height", "3.0")
			.contentType(MediaType.ALL_VALUE).accept(MediaType.ALL_VALUE))//I am getting the null pointer exception when i invoke this url.
			.andExpect(status().isOk()).andExpect(content().string("Invalid Request"));
}

}

