package io.pragra.learning.mvc2.service;

import io.pragra.learning.mvc2.domain.Course;
import io.pragra.learning.mvc2.repo.CourseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private CourseRepo repo;

    public CourseService(CourseRepo repo) {
        this.repo = repo;
    }

    public Course addCourse(Course course){
        return repo.save(course);
    }


    public List<Course> getAll(){
        return repo.findAll();
    }
}
