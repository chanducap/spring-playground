package com.gal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gal.DAO.LessonRepository;
import com.gal.vo.Lesson;

@RestController
@RequestMapping("/lessons")
public class LessonsController {
	@Autowired
	private LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    /*@GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }*/
    
    @GetMapping("/{user}")
    public Lesson all(@PathVariable Long user) {
        return this.repository.findOne(user);
    }

    @PostMapping("/lesson")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }
    
    @DeleteMapping("/{DeleteUserId}")
    public void DeleteUser(@PathVariable Long DeleteUserId) {
         this.repository.delete(DeleteUserId);
    }
    
    @PatchMapping("/{lessonNum}")
    public Lesson updateSomeDetails(@PathVariable Long lessonNum,@RequestBody Lesson lesson) {
         Lesson record=repository.findOne(lessonNum);
         record.setId(lesson.getId());
         record.setTitle(lesson.getTitle());
         record.setDeliveredOn(lesson.getDeliveredOn());
        return this.repository.save(record);
         
         
    }

}
