package com.example.demo.controller;

import com.example.demo.dto.Student;
import com.example.demo.service.FeignServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private FeignServiceUtil feignServiceUtil;

    @GetMapping("/{id}")
    public ResponseEntity getStudent(@PathVariable("id") int id) {
        Student student = null;
        try {
            student = feignServiceUtil.getStudent(id);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return feignServiceUtil.createStudent(student);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") int id){
        feignServiceUtil.deleteStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable("id") int id, @RequestBody Student student){
        return feignServiceUtil.updateStudent(id, student);
    }


}

