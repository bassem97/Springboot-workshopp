package com.gdsc.springbootworkshop.Services.Classroom;

import com.gdsc.springbootworkshop.entities.Classroom;
import com.gdsc.springbootworkshop.entities.Student;
import com.gdsc.springbootworkshop.utils.AttributeType;

import javax.management.Attribute;
import java.util.List;

public interface IClassroomService {
        Classroom findById(Long id) ;
        List<Student> getStudentsByClassroomName(String name) ;
}
