package com.example.demo.service;

import com.example.demo.dto.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value="access-api", url="http://localhost:8081/students")
public interface FeignServiceUtil {
    @GetMapping("/{id}")
    Student getStudent(@PathVariable("id") int id);

    @PostMapping
    Student createStudent(Student student);

    @DeleteMapping("/{id}")
    void deleteStudentById(@PathVariable("id") int id);

    @PutMapping("/{id}")
    Student updateStudent(@PathVariable("id") int id, Student student);
}
