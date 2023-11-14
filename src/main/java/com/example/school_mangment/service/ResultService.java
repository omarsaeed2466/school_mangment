package com.example.school_mangment.service;

import com.example.school_mangment.Entity.Lecature;
import com.example.school_mangment.Entity.Result;
import com.example.school_mangment.Repository.LectureRepository;
import com.example.school_mangment.Repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultService {

    private final ResultRepository resultRepository;
@Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }


    public Result AddNewResult(Result result){
        return this.resultRepository.save(result);
    }
    public Result findById(Integer id) {
        if(id==0)
            throw new IllegalStateException("this id result not found");

        Optional<Result> add = resultRepository.findById(id);
        if(add !=null&&add .get()!=null){
            return add .get();
        }
        return null;
    }
    public void deleteResultById(Integer resultId) {
        boolean exists = resultRepository.existsById(resultId);
        if (!exists) {
            throw new IllegalStateException("Result with id " + resultId + "does not exist");
        }
        this.resultRepository .deleteById(resultId);
    }
    public Result updateResul(Result result){
        return this.resultRepository.save(result);
    }
}
