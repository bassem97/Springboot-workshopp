package com.gdsc.springbootworkshop.controllers;

import com.gdsc.springbootworkshop.Services.IStudentService;
import com.gdsc.springbootworkshop.entities.Student;
import com.gdsc.springbootworkshop.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @Autowired
    StudentRepository studentRepository;


    @GetMapping("")
    List<Student> findAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("")
    Student addStudent(@RequestBody Student student) throws Exception {
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    Student updateStudent(@PathVariable("id") Long id,@RequestBody  Student student) throws Exception {
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping("/{id}")
    void deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
    }

    @GetMapping("/{id}")
    Student findById(@PathVariable("id") Long id){
        return studentService.findById(id);
    }


}
