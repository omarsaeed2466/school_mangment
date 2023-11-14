package com.example.school_mangment.Repository;

import com.example.school_mangment.Entity.Lecature;
import com.example.school_mangment.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LectureRepository extends JpaRepository<Lecature, Integer> {
}
