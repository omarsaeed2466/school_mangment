package com.example.school_mangment.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;

@Entity
@Table
@Getter
@Setter
public class Result {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int Id;
    @Column(name = "Result_grade")
    private double grade;

    @NotEmpty(message = "Evaluation should be set to one of these values 'COMPLETED, NOT_COMPLETED, PASS, FAIL'")
    @Column(name = "Result_evaluation")
    private String evaluation;

    @ManyToOne(/*cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH}*/optional = false)
    private Student student;

    public void setEvaluation(String evaluation) {

        for (Evaluation evaluateVal : Evaluation.values()) {

            if (evaluateVal.toString().equals(evaluation)) {
                this.evaluation = evaluation;
            }
        }
    }

    public Result() {
    }

    public Result(int id, double grade, String evaluation) {
        Id = id;
        this.grade = grade;
        this.evaluation = evaluation;
    }

    @Override
    public String toString() {
        return "Result{" +
                "Id=" + Id +
                ", grade=" + grade +
                ", evaluation='" + evaluation + '\'' +
                '}';
    }
}
