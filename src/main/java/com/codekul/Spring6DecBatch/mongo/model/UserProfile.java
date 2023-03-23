package com.codekul.Spring6DecBatch.mongo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Document
public class UserProfile {
    @Id
    private String id;
    private String bio;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date birthDate;
    private String qualification;
    @DBRef
    private User user;
    private List<String> hobbies;

}
