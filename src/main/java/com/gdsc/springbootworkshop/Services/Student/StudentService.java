package com.gdsc.springbootworkshop.Services.Student;

import com.gdsc.springbootworkshop.Services.ICrudservice;
import com.gdsc.springbootworkshop.entities.Student;
import com.gdsc.springbootworkshop.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements ICrudservice<Student,Long>,  IStudentService {

    @Autowired
    StudentRepository studentRepository;


    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student add(Student student) throws Exception {
        if(studentRepository.findByEmail(student.getEmail())  != null)
            throw new Exception("Student  already exists");
        return studentRepository.save(student);
    }

    @Override
    public Student update(Long id, Student student) throws Exception {
        if (studentRepository.findById(id).isPresent()) {
            Student toUpdatedStudent = studentRepository.findById(id).get();
            toUpdatedStudent.setEmail(student.getEmail());
            toUpdatedStudent.setGender(student.getGender());
            toUpdatedStudent.setFirstName(student.getFirstName());
            toUpdatedStudent.setLastName(student.getLastName());
            toUpdatedStudent.setClassroom(student.getClassroom());
            return studentRepository.save(toUpdatedStudent);
        }
        throw new Exception("Student does not exist");
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findById(Long aLong) {
        return studentRepository.findById(aLong).get();
    }









}
