package com.qadeer.student.controller;


import com.qadeer.student.VO.ResponseTemplateVO;
import com.qadeer.student.model.Student;
import com.qadeer.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getStudentWithCourse(@PathVariable("id") int id){
        return studentService.getStudentWithCourse(id);
    }
}
