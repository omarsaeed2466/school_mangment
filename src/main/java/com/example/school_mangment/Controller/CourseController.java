package com.example.school_mangment.Controller;

import com.example.school_mangment.Entity.Course;
import com.example.school_mangment.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Course")
public class CourseController {

    private final CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping("/getAllCourses")
    public List<Course> getAllCourse(){
        return this.courseService.getAllCourse();
    }
    @PostMapping("/AddNewCourse")
    public Course AddNewCourse(@RequestBody Course course){
        return this.courseService.AddNewCourse(course);
    }
    @GetMapping("/{id}")
    public Course findById(@PathVariable Integer id){
        return this.courseService.findById(id);
    }
    @DeleteMapping(path = "{CourseId}")
    public void deleteCourse(@PathVariable("CourseId") Integer CourseId){
        this.courseService.deleteCourseById(CourseId);
    }
    @PostMapping("/updateCourse")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }
}
