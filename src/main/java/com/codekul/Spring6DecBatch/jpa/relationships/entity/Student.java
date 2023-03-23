package com.codekul.Spring6DecBatch.jpa.relationships.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Student name can not be null")
    @NotEmpty(message = "Student name can not be empty")
    @NotBlank(message = "Student name can not be blank")
    @Size(min = 2,max = 50,message = "At least 2 characters expected")
    private String name;

    @Min(value = 3,message = "Age must be greater than 3")
    @Max(value = 16,message = "Age must be less than 16")
    @Digits(integer = 2,fraction = 0,message = "Please enter valid age")
    private Integer age;

    @NotNull(message = "Email can not be null")
    @NotEmpty(message = "Email can not be empty")
    @NotBlank(message = "Email can not be blank")
    @Email(message = "Please enter valid email id")
    private String email;

//    @PastOrPresent
//    private Date birthDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_courses",joinColumns = {@JoinColumn(name="student_id")},
    inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private List<Courses> courses;


}
