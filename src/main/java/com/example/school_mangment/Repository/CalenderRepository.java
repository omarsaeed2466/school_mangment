package com.example.school_mangment.Repository;

import com.example.school_mangment.Entity.Assignment;
import com.example.school_mangment.Entity.Calender;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CalenderRepository extends JpaRepository<Calender,Integer> {
}
