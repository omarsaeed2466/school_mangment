package com.example.school_mangment.service;

import com.example.school_mangment.Entity.Address;
import com.example.school_mangment.Entity.Assignment;
import com.example.school_mangment.Repository.AddressRepository;
import com.example.school_mangment.Repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
@Autowired
    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public List<Assignment> getAllAssignment(){
        return this.assignmentRepository.findAll();
    }
    public Assignment AddNewAssignment(Assignment assignment){
        return this.assignmentRepository.save(assignment);
    }
    public Assignment findById(Integer id) {
        if(id==0)
            throw new IllegalStateException("this id Assignment not found");

        Optional<Assignment> asi = assignmentRepository.findById(id);
        if(asi !=null&&asi.get()!=null){
            return asi .get();
        }
        return null;
    }
    public void deleteAssignmentById(Integer AssignmentId) {
        boolean exists = assignmentRepository.existsById(AssignmentId);
        if (!exists) {
            throw new IllegalStateException("Assignment with id " + AssignmentId + "does not exist");
        }
        this.assignmentRepository .deleteById(AssignmentId);
    }
    public Assignment updateAssignment(Assignment assignment){
        return this.assignmentRepository.save(assignment);
    }
}
