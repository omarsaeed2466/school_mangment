package com.example.school_mangment.Controller;

import com.example.school_mangment.Entity.Course;
import com.example.school_mangment.Entity.Lecature;
import com.example.school_mangment.service.CourseService;
import com.example.school_mangment.service.LecatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Lecature")
public class LecatureConroller {

    private final LecatureService lecatureService;
@Autowired
    public LecatureConroller(LecatureService lecatureService) {
        this.lecatureService = lecatureService;
    }

    @GetMapping("/getAllLecature")
    public List<Lecature> getAllLecature(){
        return this.lecatureService.getAllLecature();
    }
    @PostMapping("/AddNewLecature")
    public Lecature AddNewLecature(@RequestBody Lecature lecature){
        return this.lecatureService.AddNewLecature(lecature);
    }
    @GetMapping("/{id}")
    public Lecature findById(@PathVariable Integer id){
        return this.lecatureService.findById(id);
    }
    @DeleteMapping(path = "{CourseId}")
    public void deleteLecature(@PathVariable("CourseId") Integer LecatureId){
        this.lecatureService.deleteLecatureById(LecatureId);
    }
    @PostMapping("/updateLecature")
    public Lecature updateLecature(@RequestBody Lecature lecature){
        return this.lecatureService.updateLecature(lecature);
    }
}
