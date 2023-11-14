package com.example.school_mangment.service;

import com.example.school_mangment.Entity.ClassRoom;
import com.example.school_mangment.Entity.Course;
import com.example.school_mangment.Repository.ClassRomeRepository;
import com.example.school_mangment.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassRomeService {
    private final ClassRomeRepository classRomeRepository;

    @Autowired
    public ClassRomeService(ClassRomeRepository classRomeRepository) {
        this.classRomeRepository= classRomeRepository;
    }
    public List<ClassRoom> getAllClassRoom(){
        return this.classRomeRepository.findAll();
    }
    public ClassRoom AddNewClassRoom(ClassRoom classRoom){
        return this.classRomeRepository.save(classRoom);
    }
    public ClassRoom findById(Integer id) {
        if(id==0)
            throw new IllegalStateException("this id ClassRoom not found");

        Optional<ClassRoom> cla = classRomeRepository.findById(id);
        if(cla!=null&&cla.get()!=null){
            return cla.get();
        }
        return null;
    }
    public void deleteClassRoomById(Integer ClassRoomId) {
        boolean exists = classRomeRepository.existsById(ClassRoomId);
        if (!exists) {
            throw new IllegalStateException("ClassRoom with id " + ClassRoomId + "does not exist");
        }
        this.classRomeRepository .deleteById(ClassRoomId);
    }
    public ClassRoom updateClassRoom(ClassRoom classRoom){
        return this.classRomeRepository.save(classRoom);
    }

}
