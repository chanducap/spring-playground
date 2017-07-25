package com.gal.controller;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.gal.DAO.LessonRepository;
import com.gal.vo.Lesson;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LessonsControllerTest {
	
	@Autowired
    MockMvc mvc;

    @Autowired
    LessonRepository repository;
    
    @Test
    @Transactional
    @Rollback
    public void testPatch() throws Exception {
        MockHttpServletRequestBuilder request = patch("/lessons/{lessonNum}",2.0)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 2.0,\"title\": \"Tesla Motors\",\"deliveredOn\": \"2017-04-22\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(2)) )
                .andExpect(jsonPath("$.title", is("Tesla Motors")))
                .andExpect(jsonPath("$.deliveredOn", is("2017-04-22")));
    }
    
   /*
    @Test
    @Transactional
    @Rollback
    public void testCreate() throws Exception {
        MockHttpServletRequestBuilder request = post("/lessons/lesson")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 3,\"title\": \"Toyota\",\"deliveredOn\": \"2017-07-22\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(7)) )
                .andExpect(jsonPath("$.title", is("Toyota")))
                .andExpect(jsonPath("$.deliveredOn", is("2017-07-22")));
    
        this.mvc.perform(request)
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", instanceOf(Lesson.class) ) );
       
    
    
    }*/
    
    
    
    
    /*@Test
    @Transactional
    @Rollback
    public void testDelete() throws Exception {
        MockHttpServletRequestBuilder request = get("/lessons/{lesson}",2.0)
                .contentType(MediaType.APPLICATION_JSON) 
                .content("{\"id\": 3,\"title\": \"Toyota\",\"deliveredOn\": \"2017-07-22\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(nullValue()) )
                .andExpect(jsonPath("$.title", is(nullValue()))
                .andExpect(jsonPath("$.deliveredOn", is(nullValue())));
    }*/
    
   
    
    
    

	
}
