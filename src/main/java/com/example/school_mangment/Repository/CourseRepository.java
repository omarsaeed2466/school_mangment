package com.example.school_mangment.Repository;

import com.example.school_mangment.Entity.Course;
import com.example.school_mangment.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
