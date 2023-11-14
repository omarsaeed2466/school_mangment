package com.example.school_mangment.Controller;

import com.example.school_mangment.Entity.Teacher;
import com.example.school_mangment.service.CourseService;
import com.example.school_mangment.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( path = "/api/v1/Teacher")
public class TeacherController {

    private final TeacherService teacherService;
    private final CourseService courseService;

    public TeacherController(TeacherService teacherService, CourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
    }
    @GetMapping("/getAllTeachers")
    public List<Teacher> getAllTeacher(){
        return  this.teacherService.getAllTeacher();
    }
    @GetMapping("/{id}")
    public Teacher findTeacherById( @PathVariable("id")Integer id){
        return this.teacherService.findById(id);
    }
    @PostMapping("/AddNewTeacher")
    public Teacher AddNewTeacher(@RequestBody Teacher teacher){
        return this.teacherService.addNewTeacher(teacher);
    }
    @DeleteMapping(path = "/{teacherId}")
    public void deleteTeacher(@PathVariable("teacherId") Integer teacherId){
        this.teacherService.deleteTeacher(teacherId);
    }
    @PostMapping("/updateTeacher")
    public Teacher updateTeacher(@RequestBody Teacher teacher){
        return this.teacherService.updateTeacher(teacher);
    }
}
