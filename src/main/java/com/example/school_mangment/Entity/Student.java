package com.example.school_mangment.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_Email")
    private String email;
    @Column(name = "day_of_birth")
    private String dob;
    @Column(name="student_Age")
    private Integer age;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Student_course",
            joinColumns = @JoinColumn(name = "Student_Id"),
            inverseJoinColumns = @JoinColumn(name = "Course_Id"))
    private List<Course> courses;





    public Student() {
    }

    public Student(Integer id, String name, String email, String dob, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    public Student(String name,
                   String email,
                   String dob,
                   Integer age) {
        this.name = name;
        this.email = email;
        this.dob=dob;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", age=" + age +
                '}';
    }
}
