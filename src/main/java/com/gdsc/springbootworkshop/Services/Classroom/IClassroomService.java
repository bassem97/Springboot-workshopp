package com.gdsc.springbootworkshop.Services.Classroom;

import com.gdsc.springbootworkshop.entities.Classroom;
import com.gdsc.springbootworkshop.entities.Student;

import java.util.List;

public interface IClassroomService {
        Classroom findById(Long id) ;
        List<Student> getStudentsByClassroomName(String name) ;
}
