package com.gdsc.springbootworkshop.Services;

import com.gdsc.springbootworkshop.entities.Student;
import com.gdsc.springbootworkshop.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) throws Exception {
        if(studentRepository.findByEmail(student.getEmail())  != null)
             throw new Exception("Student  already exists");
        return studentRepository.save(student);
    }



    @Override
    public Student updateStudent(Long id, Student student) throws Exception{
        if (studentRepository.findById(id).isPresent()) {
            Student toUpdatedStudent = studentRepository.findById(id).get();
            toUpdatedStudent.setEmail(student.getEmail());
            toUpdatedStudent.setGender(student.getGender());
            toUpdatedStudent.setFirstName(student.getFirstName());
            toUpdatedStudent.setLastName(student.getLastName());
            return studentRepository.save(toUpdatedStudent);
        }
        throw new Exception("Student does not exist");
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }


}
