package com.example.school_mangment.service;

import com.example.school_mangment.Entity.Teacher;
import com.example.school_mangment.Repository.CourseRepository;
import com.example.school_mangment.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, CourseRepository courseRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeacher(){
        return this.teacherRepository.findAll();
    }
    public Teacher findById(Integer id){
        if(id==0)
            throw new IllegalStateException("this id Teacher not found ");
        Optional<Teacher> tea = this.teacherRepository.findById(id);
        if(tea!=null&& tea.get()!=null){
            return tea.get();
        }
        return null;
    }


    public Teacher addNewTeacher(Teacher teacher) {

        return  this. teacherRepository.save(teacher);
    }

    public void deleteTeacher(Integer teachertId) {
        boolean exists = teacherRepository.existsById(teachertId);
        if (!exists) {
            throw new IllegalStateException("student with id " + teachertId + "does not exist");
        }
        teacherRepository.deleteById(teachertId);
    }
    public Teacher updateTeacher (Teacher teacher){
        return this.teacherRepository.save(teacher);
    }

    public List<Teacher> initDefaultTeachers(){
        String[] teachers = {"Mohamed","Ahmed","Adel"};
        if(this.teacherRepository.count() ==0){
            List<Teacher> teacherList = new ArrayList<>();
            for(String teacher:teachers){
                teacherList.add(this.teacherRepository.saveAndFlush(new Teacher(teacher,teacher+"@gmail.com")));
            }
            return teacherList;
        }

        return null;

    }
}
