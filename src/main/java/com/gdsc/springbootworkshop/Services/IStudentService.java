package com.gdsc.springbootworkshop.Services;

import com.gdsc.springbootworkshop.entities.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    List<Student> getAllStudents();
    Student addStudent(Student student)  throws Exception ;
    Student updateStudent(Long id,Student student) throws Exception ;
    void deleteStudent(Long id);


}
