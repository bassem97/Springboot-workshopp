package com.gdsc.springbootworkshop.controllers;

import com.gdsc.springbootworkshop.Services.IStudentService;
import com.gdsc.springbootworkshop.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    IStudentService studentService;


    @GetMapping("")
    List<Student> findAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("")
    Student addStudent(@RequestBody Student student) throws Exception {
        return studentService.addStudent(student);
    }


}
