package com.gdsc.springbootworkshop.controllers;

import com.gdsc.springbootworkshop.Services.Student.StudentService;
import com.gdsc.springbootworkshop.entities.Student;
import com.gdsc.springbootworkshop.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping("")
    ResponseEntity<Response<Student>> findAllStudents(){

        try {
            return ResponseEntity.ok().body(new Response<Student>(true, HttpStatus.OK.value(), "Students retrieved successfully", studentService.getAll()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Response<Student>(false, HttpStatus.BAD_REQUEST.value(), e.getMessage(), null));
        }
    }

    @PostMapping("")
    Student addStudent(@RequestBody Student student) throws Exception {
        return studentService.add(student);
    }

    @PutMapping("/{id}")
    Student updateStudent(@PathVariable("id") Long id,@RequestBody  Student student) throws Exception {
        return studentService.update(id,student);
    }

    @DeleteMapping("/{id}")
    void deleteStudent(@PathVariable("id") Long id){
        studentService.delete(id);
    }

    @GetMapping("/{id}")
    Student findById(@PathVariable("id") Long id){
        return studentService.findById(id);
    }


}
