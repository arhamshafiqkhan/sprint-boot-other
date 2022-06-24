package com.qadeer.student.service;

import com.qadeer.student.exception.ApiRequestException;
import com.qadeer.student.model.Student;
import com.qadeer.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }


    public Student getStudent(int id) {
        return studentRepository.findStudentById(id);
    }

    public void deleteStudentById(int id){
        Student student = studentRepository.findStudentById(id);
        studentRepository.delete(student);
    }

    public Student updateStudent(int id, Student student){
        Student currentStudent = studentRepository.findStudentById(id);
        if (currentStudent == null) {
            throw new ApiRequestException("This student you are trying to update does not exist.");
        }
        currentStudent.setAge(student.getAge());
        currentStudent.setName(student.getName());
        currentStudent.setRollNo(student.getRollNo());
        return studentRepository.save(currentStudent);
    }
}
