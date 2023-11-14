package com.example.school_mangment.Controller;

import com.example.school_mangment.Entity.Student;
import com.example.school_mangment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/getAllStudents")
    public List<Student> getStudents(){
        return this.studentService.getStudent();
    }
    @PostMapping("/insert_new_student")
    public void addNewStudent(@RequestBody Student student){
        this.studentService.addNewStudent(student);
    }
    @DeleteMapping(path = "{studentId}")
    public void deletestudent(@PathVariable("studentId") Integer studentId){
        studentService.deleteStudent(studentId);
    }
    @PostMapping("/updateStudent")
    public Student updateStudent (@RequestBody Student student){
        return  this.studentService.updateStudent(student);
    }
}
