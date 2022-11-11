package com.gdsc.springbootworkshop.Services.Classroom;


import com.gdsc.springbootworkshop.Services.Classroom.IClassroomService;
import com.gdsc.springbootworkshop.Services.ICrudservice;
import com.gdsc.springbootworkshop.entities.Classroom;
import com.gdsc.springbootworkshop.repositories.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService implements IClassroomService, ICrudservice<Classroom,Long> {

    @Autowired
    ClassroomRepository classroomRepository;

    @Override
    public List<Classroom> getAll() {
        return classroomRepository.findAll();
    }

    @Override
    public Classroom add(Classroom classroom) throws Exception {
        if(classroomRepository.findByName(classroom.getName())  != null)
            throw new Exception("Classroom  already exists");
        return classroomRepository.save(classroom);
    }

    @Override
    public Classroom update(Long id, Classroom classroom) throws Exception {
        if (classroomRepository.findById(id).isPresent()) {
            Classroom toUpdatedClassroom = classroomRepository.findById(id).get();
            toUpdatedClassroom.setName(classroom.getName());
            return classroomRepository.save(toUpdatedClassroom);
        }
        throw new Exception("Classroom does not exist");
    }

    @Override
    public void delete(Long id) {
        classroomRepository.deleteById(id);
    }

    @Override
    public Classroom findById(Long aLong) {
        return classroomRepository.findById(aLong).get();
    }


}
