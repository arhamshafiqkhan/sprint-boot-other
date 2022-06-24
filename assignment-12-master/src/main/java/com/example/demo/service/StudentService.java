package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public ResponseEntity<Student> findStudentById(@PathVariable(value = "id") int id){
        Optional<Student> student = studentRepository.findById(id);

        if(student.isPresent()){
            return ResponseEntity.ok().body(student.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    public Student createStudent(@Validated @RequestBody Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(int id, Student updatedStudent){
        Student currentStudent = studentRepository.findById(id).orElse(null);
        currentStudent.setName(updatedStudent.getName());
        currentStudent.setRollNo(updatedStudent.getRollNo());
        currentStudent.setAge(updatedStudent.getAge());

        studentRepository.save(currentStudent);
        return currentStudent;
    }

    public void deleteStudent(@PathVariable(value = "id") int id){
        studentRepository.deleteById(id);
    }

}
