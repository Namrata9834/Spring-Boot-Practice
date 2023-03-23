package com.codekul.Spring6DecBatch.jpa.relationships.service.impl;

import com.codekul.Spring6DecBatch.jpa.relationships.entity.Student;
import com.codekul.Spring6DecBatch.jpa.relationships.repository.StudentRepository;
import com.codekul.Spring6DecBatch.jpa.relationships.service.StudentService;
import com.codekul.Spring6DecBatch.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public ResponseEntity<?> saveStudent(Student student) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setMessage("Student saved successfully");
        studentRepository.save(student);
        return ResponseEntity.ok(apiResponse);
    }
}
