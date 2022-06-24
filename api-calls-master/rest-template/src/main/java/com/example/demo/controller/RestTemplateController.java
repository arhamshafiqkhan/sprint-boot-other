package com.example.demo.controller;


import com.example.demo.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest")
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    public static String url = "http://localhost:8081/students";


    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id){
        ResponseEntity<Student> student = restTemplate.getForEntity(url + "/" + id, Student.class);
        return student;

    }
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        Student myStudent = restTemplate.postForObject(url, student, Student.class);
        return myStudent;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id){
        restTemplate.delete(url + "/" + id);
    }


    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody Student student) {
        restTemplate.put(url + "/" + id, student);
    }
}
