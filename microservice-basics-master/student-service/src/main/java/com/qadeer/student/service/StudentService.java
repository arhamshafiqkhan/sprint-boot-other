package com.qadeer.student.service;

import com.qadeer.student.VO.Course;
import com.qadeer.student.VO.ResponseTemplateVO;
import com.qadeer.student.model.Student;
import com.qadeer.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public ResponseTemplateVO getStudentWithCourse(int id) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Student student = studentRepository.findStudentById(id);
        Course course = restTemplate.getForObject("http://COURSE-SERVICE/courses/" + student.getCourseId(), Course.class);
        vo.setStudent(student);
        vo.setCourse(course);
        return vo;




    }
}
