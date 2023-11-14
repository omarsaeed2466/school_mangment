package com.example.school_mangment.Controller;

import com.example.school_mangment.Entity.Address;
import com.example.school_mangment.Entity.Assignment;
import com.example.school_mangment.service.AddressService;
import com.example.school_mangment.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Assignment")
public class AssignmentConroller {

    private final AssignmentService assignmentService;
@Autowired
    public AssignmentConroller(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping("/getAllAAssignment")
    public List<Assignment> getAllAssignment(){
        return this.assignmentService.getAllAssignment();
    }

    @PostMapping("/AddNewAssignment")
    public  Assignment AddNewAssignment(@RequestBody Assignment assignment){
        return this.assignmentService.AddNewAssignment(assignment);
}
    @GetMapping("/{id}")
    public Assignment findById(@PathVariable Integer id){
        return this.assignmentService.findById(id);
    }


    @DeleteMapping(path = "{AssignmentId}")
    public void deleteAssignment(@PathVariable("AssignmentId") Integer AssignmentId){
        this.assignmentService.deleteAssignmentById(AssignmentId);
    }
    @PostMapping("/updateAssignment")
    public Assignment updateAssignment(@RequestBody Assignment assignment){
        return this.assignmentService.updateAssignment(assignment);
    }

}
