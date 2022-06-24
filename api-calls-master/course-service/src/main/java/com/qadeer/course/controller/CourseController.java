package com.qadeer.course.controller;

import com.qadeer.course.model.Course;
import com.qadeer.course.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
@Slf4j
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }

    @GetMapping("/{id}")
    public Course findCourseById(@PathVariable("id") int id){
        return courseService.findCourseById(id);
    }
}
