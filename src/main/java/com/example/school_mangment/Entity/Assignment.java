package com.example.school_mangment.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @NotNull
    @Column(name = "deadLine")
    private LocalDate deadLine;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Assignment_results",
            joinColumns = @JoinColumn(name = "results_Id"),
            inverseJoinColumns = @JoinColumn(name = "Assignment_Id"))
    private List<Result> results;

    public Assignment() {
    }

    public Assignment(Integer id, String name, String description, LocalDate deadLine) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", deadLine=" + deadLine +
                '}';
    }
}
