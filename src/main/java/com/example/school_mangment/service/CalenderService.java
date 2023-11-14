package com.example.school_mangment.service;


import com.example.school_mangment.Entity.Calender;

import com.example.school_mangment.Repository.CalenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CalenderService {

    private final CalenderRepository calenderRepository;
@Autowired
    public CalenderService(CalenderRepository calenderRepository) {
        this.calenderRepository = calenderRepository;
    }


    public Calender AddNewCalender(Calender calender){
        return this.calenderRepository.save(calender);
    }
    public Calender findById(Integer id) {
        if(id==0)
            throw new IllegalStateException("this id Calender not found");

        Optional<Calender> cal = calenderRepository.findById(id);
        if(cal !=null&&cal.get()!=null){
            return cal .get();
        }
        return null;
    }
    public void deleteCalenderById(Integer CalenderId) {
        boolean exists = calenderRepository.existsById(CalenderId);
        if (!exists) {
            throw new IllegalStateException("Calender with id " + CalenderId + "does not exist");
        }
        this.calenderRepository .deleteById(CalenderId);
    }
    public Calender updateCalender(Calender calender){
        return this.calenderRepository.save(calender);
    }
}
