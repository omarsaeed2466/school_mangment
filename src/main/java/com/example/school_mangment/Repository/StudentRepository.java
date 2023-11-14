package com.example.school_mangment.Repository;

import com.example.school_mangment.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> FindStudentByEmail(String email);
}
