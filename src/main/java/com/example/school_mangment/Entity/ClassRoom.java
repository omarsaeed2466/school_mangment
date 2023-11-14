package com.example.school_mangment.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter

public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "classRome_name")
    private String name;
    @Column(name = "classRome_description")
    private String description;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Student_course",
            joinColumns = @JoinColumn(name = "Student_Id"),
            inverseJoinColumns = @JoinColumn(name = "ClassRome_Id"))
    private List<Student> student;
    @ManyToOne(/*cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH}*/optional = false)
    private Teacher teacher;

    public ClassRoom() {
    }

    public ClassRoom(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
