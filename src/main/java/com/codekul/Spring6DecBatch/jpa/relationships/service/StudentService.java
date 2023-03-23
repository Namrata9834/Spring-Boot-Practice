package com.codekul.Spring6DecBatch.jpa.relationships.service;

import com.codekul.Spring6DecBatch.jpa.relationships.entity.Student;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    ResponseEntity<?> saveStudent(Student student);
}
