package com.example.school_mangment;

import com.example.school_mangment.Entity.Teacher;
import com.example.school_mangment.service.CourseService;
import com.example.school_mangment.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class SchoolMangmentApplication {
//	@Autowired
//	CourseService courseService;
//	@Autowired
	TeacherService teacherService;
	public static void main(String[] args) {
		SpringApplication.run(SchoolMangmentApplication.class, args);
	}
//	@EventListener({ApplicationReadyEvent.class})
//	public void doSomeThing(){
//		List<Teacher> teachers= this.teacherService.initDefaultTeachers();
//		this.courseService.initDefaultCourses(teachers);
	}

