package com.gal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.gal.service.MathService;

@RunWith(SpringRunner.class)
@ContextConfiguration
@WebMvcTest(MathService.class)
@WebAppConfiguration
public class SpringPlaygroundApplicationTests {

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
		this.mockMvc.perform(get("/math/calculate/operation={opera}&x={var1}&y={var2}", "add", 1.0, 2.0)
				.accept(MediaType.TEXT_PLAIN_VALUE)).andDo(print()).andExpect(status().isOk())
		        .andExpect(content().string("3.0"));
				

	}
}
