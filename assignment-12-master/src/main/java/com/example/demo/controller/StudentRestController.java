package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable(value = "id") int id){
        return studentService.findStudentById(id);
    }

    @PostMapping
    public void createStudent(@Validated @RequestBody Student student){
        studentService.createStudent(student);
    }

    @PutMapping("{id}")
    public void updateStudent(@PathVariable int id, @RequestBody Student student){
        studentService.updateStudent(id, student);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable(value = "id") int id){
        studentService.deleteStudent(id);
    }
}
