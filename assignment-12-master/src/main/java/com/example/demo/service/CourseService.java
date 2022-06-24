package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public ResponseEntity<Course> findCourseById(@PathVariable(value = "id") int id) {

        // Optional is a container object used to contain not-null objects.
        Optional<Course> course = courseRepository.findById(id);

        if(course.isPresent()) {
            return ResponseEntity.ok().body(course.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
