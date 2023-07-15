package com.gdsc.springbootworkshop.repositories;

import com.gdsc.springbootworkshop.entities.Classroom;
import com.gdsc.springbootworkshop.entities.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
  Classroom findByName(String name);

  @Query("select s from Student s where s.classroom.name = ?1")
  List<Student> getStudentsByClassroomName(String name);
}
