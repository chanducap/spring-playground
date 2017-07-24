package com.gal.DAO;

import org.springframework.data.repository.CrudRepository;

import com.gal.vo.Lesson;


public interface LessonRepository extends CrudRepository<Lesson, Long> {
	

}