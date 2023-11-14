package com.example.school_mangment.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class Calender {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int Id;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @NotNull
    @Column(name = "startDate")
    private LocalDateTime startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @NotNull
    @Column(name = "endDate")
    private LocalDateTime endDate;

    @ManyToOne(/*cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH}*/optional = false)
    private Lecature lecture;

    private String dayOfWeek;

    public Calender() {
    }

    public Calender(int id, LocalDateTime startDate, LocalDateTime endDate, Lecature lecture, String dayOfWeek) {
        Id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.lecture = lecture;
        this.dayOfWeek = dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {

        for (DayOfWeek dayOfWeekVal : DayOfWeek.values()) {

            if (dayOfWeekVal.toString().equals(dayOfWeek)) {
                this.dayOfWeek = dayOfWeek;
            }
        }


    }

    @Override
    public String toString() {
        return "Calender{" +
                "Id=" + Id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", lecture=" + lecture +
                '}';
    }
}
