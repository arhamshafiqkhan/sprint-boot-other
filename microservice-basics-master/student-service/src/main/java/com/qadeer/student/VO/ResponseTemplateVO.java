package com.qadeer.student.VO;

import com.qadeer.student.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private Student student;
    private Course course;
}
