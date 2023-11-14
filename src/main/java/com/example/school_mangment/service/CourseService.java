package com.example.school_mangment.service;

import com.example.school_mangment.Entity.Course;
import com.example.school_mangment.Entity.Teacher;
import com.example.school_mangment.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public List<Course> getAllCourse(){
        return this.courseRepository.findAll();
    }
    public Course AddNewCourse(Course course){
        return this.courseRepository.save(course);
    }
    public Course findById(Integer id) {
        if(id==0)
            throw new IllegalStateException("this id course not found");

        Optional<Course> cor = courseRepository.findById(id);
        if(cor!=null&&cor.get()!=null){
            return cor.get();
        }
        return null;
    }
    public void deleteCourseById(Integer CourseId) {
        boolean exists = courseRepository.existsById(CourseId);
        if (!exists) {
            throw new IllegalStateException("Course with id " + CourseId + "does not exist");
        }
        this.courseRepository .deleteById(CourseId);
    }
    public Course updateCourse(Course course){
        return this.courseRepository.save(course);
    }


    }

