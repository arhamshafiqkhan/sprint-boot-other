package com.qadeer.course.service;

import com.qadeer.course.model.Course;
import com.qadeer.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course findCourseById(int id){
        return courseRepository.findCourseById(id);
    }
}
