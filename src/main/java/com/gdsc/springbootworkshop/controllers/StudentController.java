package com.gdsc.springbootworkshop.controllers;

import com.gdsc.springbootworkshop.Services.Student.StudentService;
import com.gdsc.springbootworkshop.entities.Student;
import com.gdsc.springbootworkshop.utils.AttributeType;
import com.gdsc.springbootworkshop.utils.Response;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
  final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("")
  ResponseEntity<Response<Student>> findAllStudents() {
    try {
      return ResponseEntity
        .ok()
        .body(
          new Response<Student>(
            true,
            HttpStatus.OK.value(),
            "Students retrieved successfully",
            studentService.getAll()
          )
        );
    } catch (Exception e) {
      return ResponseEntity
        .badRequest()
        .body(
          new Response<Student>(
            false,
            HttpStatus.BAD_REQUEST.value(),
            e.getMessage(),
            null
          )
        );
    }
  }

  @PostMapping("")
  ResponseEntity<Response<Student>> addStudent(@RequestBody Student student)
    throws Exception {
    try {
      return ResponseEntity
        .ok()
        .body(
          new Response<Student>(
            true,
            HttpStatus.OK.value(),
            "Student added successfully",
            List.of(studentService.add(student))
          )
        );
    } catch (Exception e) {
      return ResponseEntity
        .badRequest()
        .body(
          new Response<Student>(
            false,
            HttpStatus.BAD_REQUEST.value(),
            e.getMessage(),
            null
          )
        );
    }
  }

  @PutMapping("/{id}")
  ResponseEntity<Response<Student>> updateStudent(
    @PathVariable("id") Long id,
    @RequestBody Student student
  )
    throws Exception {
    try {
      return ResponseEntity
        .ok()
        .body(
          new Response<Student>(
            true,
            HttpStatus.OK.value(),
            "Student updated successfully",
            List.of(studentService.update(id, student))
          )
        );
    } catch (Exception e) {
      return ResponseEntity
        .badRequest()
        .body(
          new Response<Student>(
            false,
            HttpStatus.BAD_REQUEST.value(),
            e.getMessage(),
            null
          )
        );
    }
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Response<Student>> deleteStudent(@PathVariable("id") Long id) {
    try {
      studentService.delete(id);
      return ResponseEntity
        .ok()
        .body(
          new Response<Student>(
            true,
            HttpStatus.OK.value(),
            "Student deleted successfully",
            null
          )
        );
    } catch (Exception e) {
      return ResponseEntity
        .badRequest()
        .body(
          new Response<Student>(
            false,
            HttpStatus.BAD_REQUEST.value(),
            e.getMessage(),
            null
          )
        );
    }
  }

  @GetMapping("/{id}")
  ResponseEntity<Response<Student>> findById(@PathVariable("id") Long id) {
    try {
      return ResponseEntity
        .ok()
        .body(
          new Response<Student>(
            true,
            HttpStatus.OK.value(),
            "Student retrieved successfully",
            List.of(studentService.findById(id))
          )
        );
    } catch (Exception e) {
      return ResponseEntity
        .badRequest()
        .body(
          new Response<Student>(
            false,
            HttpStatus.BAD_REQUEST.value(),
            e.getMessage(),
            null
          )
        );
    }
  }

  @GetMapping("/fields")
  ResponseEntity<Response<AttributeType>> fields() {
    try {
      return ResponseEntity
        .ok()
        .body(
          new Response<>(
            true,
            HttpStatus.OK.value(),
            "Fields retrieved successfully",
            studentService.getStudentFields()
          )
        );
    } catch (Exception e) {
      return ResponseEntity
        .badRequest()
        .body(
          new Response<>(
            false,
            HttpStatus.BAD_REQUEST.value(),
            e.getMessage(),
            null
          )
        );
    }
  }
}
