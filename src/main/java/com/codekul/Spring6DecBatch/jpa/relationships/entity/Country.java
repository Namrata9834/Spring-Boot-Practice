package com.codekul.Spring6DecBatch.jpa.relationships.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String countryCode;

    @Column(unique = true)
    private String countryName;

}
