package com.codekul.Spring6DecBatch.jpa.relationships.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Capital {
    @Id  //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Long id;

    @Column(unique = true)
    private String capital;


    @OneToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
