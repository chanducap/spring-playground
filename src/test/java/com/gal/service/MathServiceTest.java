package com.gal.service;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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

import com.gal.controller.MathController;

@RunWith(SpringRunner.class)
@WebMvcTest(MathService.class)
public class MathServiceTest {

	@Autowired
	private WebApplicationContext ctx;

	@Autowired
	private MathService mathService;

	@Test
	public void testMathService() {

		assertEquals(5, mathService.add(2.0, 3.0), 0.0);
		assertEquals(9, mathService.mul(3.0, 3.0), 0.0);
		assertEquals(4, mathService.divide(12.0, 3.0), 0.0);
		assertEquals(2, mathService.sub(13.0, 11.0), 0.0);

		List<Double> a1 = new ArrayList<>();
		a1.add(51.0);
		a1.add(2.0);

		assertEquals(53, mathService.findSum(a1), 0.0);
		assertEquals(16.0, mathService.volume(1.0, 4.0, 4.0), 0.0);

	}

}
