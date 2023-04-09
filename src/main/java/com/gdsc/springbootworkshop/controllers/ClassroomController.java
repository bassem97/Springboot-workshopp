package com.gdsc.springbootworkshop.controllers;

import com.gdsc.springbootworkshop.Services.Classroom.ClassroomService;
import com.gdsc.springbootworkshop.entities.Classroom;
import com.gdsc.springbootworkshop.entities.Student;
import com.gdsc.springbootworkshop.utils.AttributeType;
import com.gdsc.springbootworkshop.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("classrooms")
@CrossOrigin(origins = "http://localhost:4200")
public class ClassroomController {

    final
    ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }


    @GetMapping("")
    ResponseEntity<Response<Classroom>> findAllClassrooms(){
        try {
            return ResponseEntity.ok().body(new Response<>(true, 200, "Classrooms retrieved successfully", classroomService.getAll()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Response<>(false, 400, e.getMessage(), null));
        }
    }

    @PostMapping("")
    ResponseEntity<Response<Classroom>> addClassroom(@RequestBody Classroom classroom) throws Exception {
        try {
            return ResponseEntity.ok().body(new Response<>(true, 200, "Classroom added successfully", List.of(classroomService.add(classroom))));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Response<>(false, 400, e.getMessage(), null));
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<Response<Classroom>> updateClassroom(@PathVariable("id") Long id,@RequestBody Classroom classroom) throws Exception {
        try {
            return ResponseEntity.ok().body(new Response<>(true, 200, "Classroom updated successfully", List.of(classroomService.update(id,classroom))));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Response<>(false, 400, e.getMessage(), null));
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Response<Classroom>> deleteClassroom(@PathVariable("id") Long id){
        try {
            classroomService.delete(id);
            return ResponseEntity.ok().body(new Response<>(true, 200, "Classroom deleted successfully", null));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Response<>(false, 400, e.getMessage(), null));
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<Response<Classroom>> findClassroomById(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok().body(new Response<>(true, 200, "Classroom retrieved successfully", List.of(classroomService.findById(id))));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Response<>(false, 400, e.getMessage(), null));
        }
    }

    @GetMapping("findStudentsByClassroomName/{name}")
    ResponseEntity<Response<Student>> findStudentsByClassroomName(@PathVariable("name") String name){
        try {
            return ResponseEntity.ok().body(new Response<>(true, 200, "Students retrieved successfully", classroomService.getStudentsByClassroomName(name)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Response<>(false, 400, e.getMessage(), null));
        }
    }


    @GetMapping("/fields")
    ResponseEntity<Response<AttributeType>> getFields(){
        try {
            return ResponseEntity.ok().body(new Response<>(true, 200, "Fields retrieved successfully", classroomService.getFields()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Response<>(false, 400, e.getMessage(), null));
        }
    }


}
