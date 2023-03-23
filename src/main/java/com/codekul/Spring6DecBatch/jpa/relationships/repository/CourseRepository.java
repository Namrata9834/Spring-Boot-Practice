package com.codekul.Spring6DecBatch.jpa.relationships.repository;

import com.codekul.Spring6DecBatch.jpa.relationships.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Courses,Long> {
}
