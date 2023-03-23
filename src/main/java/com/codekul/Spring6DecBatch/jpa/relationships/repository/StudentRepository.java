package com.codekul.Spring6DecBatch.jpa.relationships.repository;

import com.codekul.Spring6DecBatch.jpa.relationships.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
