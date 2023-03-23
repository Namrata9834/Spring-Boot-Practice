package com.codekul.Spring6DecBatch.jpa.relationships.controller;

import com.codekul.Spring6DecBatch.jpa.relationships.entity.Student;
import com.codekul.Spring6DecBatch.jpa.relationships.repository.StudentRepository;
import com.codekul.Spring6DecBatch.jpa.relationships.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return ResponseEntity.ok("Student Saved");
    }
}
