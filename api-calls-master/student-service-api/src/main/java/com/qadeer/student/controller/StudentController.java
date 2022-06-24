package com.qadeer.student.controller;

import com.qadeer.student.exception.ApiRequestException;
import com.qadeer.student.model.Student;
import com.qadeer.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;


    //Try to write the controller methods with proper try catch blocks and if multiple exceptions throw exception with proper messages for upstream system

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student myStudent = studentService.createStudent(student);
        String name = myStudent.getName();
        int age = myStudent.getAge();
        int roll = myStudent.getRollNo();
        int course = myStudent.getCourseId();
        if (name.length() == 0 || age<1 || roll<0 || course < 1){
            throw new ApiRequestException("The data entered is incorrect");
        }
        return new ResponseEntity(student, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
        Student student = studentService.getStudent(id);
        if (student == null) {
            throw new ApiRequestException("The student you are trying to get does not exist.");
        }
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudentById(@PathVariable("id") int id){
        Student student = studentService.getStudent(id);
        if (student == null) {
            throw new ApiRequestException("The student you are trying to delete does not exist.");
        }
        studentService.deleteStudentById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student){
        String name = student.getName();
        int age = student.getAge();
        int roll = student.getRollNo();
        int course = student.getCourseId();
        if (name.length() == 0 || age<1 || roll<0 || course < 1){
            throw new ApiRequestException("The data entered for updating student is incorrect");
        }
        Student myStudent =  studentService.updateStudent(id, student);
        return new ResponseEntity<>(myStudent, HttpStatus.OK);
    }
}
