package com.gdsc.springbootworkshop.Services.Student;

import com.gdsc.springbootworkshop.entities.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {


    Student findById(   Long id);
}
