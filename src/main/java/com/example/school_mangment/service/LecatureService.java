package com.example.school_mangment.service;

import com.example.school_mangment.Entity.Address;
import com.example.school_mangment.Entity.Lecature;
import com.example.school_mangment.Repository.AddressRepository;
import com.example.school_mangment.Repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LecatureService {

    private final LectureRepository lectureRepository;
@Autowired
    public LecatureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public List<Lecature> getAllLecature(){
        return this.lectureRepository.findAll();
    }
    public Lecature AddNewLecature(Lecature lecature){
        return this.lectureRepository.save(lecature);
    }
    public Lecature findById(Integer id) {
        if(id==0)
            throw new IllegalStateException("this id Lecature not found");

        Optional<Lecature> add = lectureRepository.findById(id);
        if(add !=null&&add .get()!=null){
            return add .get();
        }
        return null;
    }
    public void deleteLecatureById(Integer LecatureId) {
        boolean exists = lectureRepository.existsById(LecatureId);
        if (!exists) {
            throw new IllegalStateException("Lecature with id " + LecatureId + "does not exist");
        }
        this.lectureRepository .deleteById(LecatureId);
    }
    public Lecature updateLecature(Lecature lecature){
        return this.lectureRepository.save(lecature);
    }
}
