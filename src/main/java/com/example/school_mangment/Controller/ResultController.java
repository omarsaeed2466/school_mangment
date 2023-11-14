package com.example.school_mangment.Controller;

import com.example.school_mangment.Entity.Result;
import com.example.school_mangment.Entity.Student;
import com.example.school_mangment.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/Result")
public class ResultController {

    private ResultService resultService ;
@Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping("/insert_new_Result")
    public void addNewResult(@RequestBody Result result){
        this.resultService.AddNewResult(result);
    }
    @DeleteMapping(path = "{resultId}")
    public void deleteresult(@PathVariable("resultId") Integer resultId){
        resultService.deleteResultById(resultId);
    }
    @PostMapping("/updateStudent")
    public Result updateResult (@RequestBody Result result){
        return  this.resultService.updateResul(result);
    }
}
