package com.example.school_mangment.Controller;

import com.example.school_mangment.Entity.Address;
import com.example.school_mangment.Entity.ClassRoom;
import com.example.school_mangment.service.AddressService;
import com.example.school_mangment.service.ClassRomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/ClassRoom")
public class ClassRomeController {

    private final ClassRomeService classRomeService;
    @Autowired
    public ClassRomeController(ClassRomeService classRomeService) {

        this.classRomeService = classRomeService;
    }
    @GetMapping("/getAllClassRome")
    public List<ClassRoom> getAllClassRome(){
        return this.classRomeService.getAllClassRoom();
    }

    @PostMapping("/AddNewClassRome")
    public  ClassRoom AddNewClassRome(@RequestBody ClassRoom classRoom){
        return this.classRomeService.AddNewClassRoom(classRoom);

    }
    @GetMapping("/{id}")
    public ClassRoom findById(@PathVariable Integer id){
        return this.classRomeService.findById(id);
    }


    @DeleteMapping(path = "{ClassRomeId}")
    public void deleteClassRome(@PathVariable("ClassRomeId") Integer ClassRome){
        this.classRomeService.deleteClassRoomById(ClassRome);
    }
    @PostMapping("/updateClassRome")
    public ClassRoom updateClassRome(@RequestBody ClassRoom classRoom){
        return this.classRomeService.updateClassRoom(classRoom);
    }

}
