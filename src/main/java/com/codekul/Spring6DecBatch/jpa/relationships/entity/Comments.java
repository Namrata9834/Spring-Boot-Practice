package com.codekul.Spring6DecBatch.jpa.relationships.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "comments")
@Getter
@Setter
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private LocalDate commentDate;
    private LocalTime commentTime;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
