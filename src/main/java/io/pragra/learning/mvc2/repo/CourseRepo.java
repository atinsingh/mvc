package io.pragra.learning.mvc2.repo;

import io.pragra.learning.mvc2.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
}
