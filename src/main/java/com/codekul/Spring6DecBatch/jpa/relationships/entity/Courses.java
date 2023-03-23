package com.codekul.Spring6DecBatch.jpa.relationships.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull(message = "Course name not be null")
    @NotEmpty(message = "Course name can not be empty")
    @NotBlank(message = "Course name can not be blank")
    @Size(min = 2,max = 30,message = "At least 2 characters expected")
    @Column(unique = true)
    private String courseName;

    @ManyToMany(mappedBy = "courses",cascade = CascadeType.ALL)
    private List<Student> students;
}
