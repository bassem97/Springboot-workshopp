package com.gdsc.springbootworkshop.Services.Student;

import com.gdsc.springbootworkshop.entities.Student;
import com.gdsc.springbootworkshop.utils.AttributeType;
import java.util.List;

public interface IStudentService {
  Student findById(Long id);

  List<AttributeType> getStudentFields();
}
