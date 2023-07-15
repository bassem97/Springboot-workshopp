package com.gdsc.springbootworkshop.Services.Classroom;

import com.gdsc.springbootworkshop.entities.Classroom;
import com.gdsc.springbootworkshop.entities.Student;
import com.gdsc.springbootworkshop.utils.AttributeType;
import java.util.List;
import javax.management.Attribute;

public interface IClassroomService {
  Classroom findById(Long id);
  List<Student> getStudentsByClassroomName(String name);
}
