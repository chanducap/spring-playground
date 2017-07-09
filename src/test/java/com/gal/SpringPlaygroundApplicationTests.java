package com.gal;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.gal.controller.MathController;
import com.gal.service.MathService;


@RunWith(SpringRunner.class)
@ContextConfiguration
@WebMvcTest(MathController.class)

public class SpringPlaygroundApplicationTests {

	@Autowired
	private WebApplicationContext ctx;
	
	@MockBean
	private MathService mathService;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}


	@Test
	public void testAddEndpoint() throws Exception {
		given(this.mathService.sum(1.0, 2.0)).willReturn(3.0);
		
		try{
		this.mockMvc.perform(get("/math/calculate?operation={opera}&x={var1}&y={var2}", "add", 1.0, 2.0)
				.accept(MediaType.TEXT_PLAIN_VALUE))
		         .andDo(print())
		         .andExpect(content().string("3.0"));
		}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	}
}
