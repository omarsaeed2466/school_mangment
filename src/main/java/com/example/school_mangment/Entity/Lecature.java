package com.example.school_mangment.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
@Getter
@Setter
public class Lecature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;


    @NotEmpty
    @Column(name = "Lecature_title")
    private String title;
    @Column(name = "Lecature_Content")
    private String Content;


    @OneToOne(/*cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH}*/optional = false)
    private ClassRoom room;

    public Lecature() {
    }


    public Lecature(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        Content = content;
    }

    @Override
    public String toString() {
        return "Lecature{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", Content='" + Content + '\'' +
                '}';
    }
}
