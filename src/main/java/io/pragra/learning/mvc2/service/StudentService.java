package io.pragra.learning.mvc2.service;

import io.pragra.learning.mvc2.domain.Course;
import io.pragra.learning.mvc2.domain.Student;
import io.pragra.learning.mvc2.exceptions.RequiredDataMissingException;
import io.pragra.learning.mvc2.repo.CourseRepo;
import io.pragra.learning.mvc2.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class StudentService {
    private StudentRepo studentRepo;
    private CourseRepo courseRepo;

    public StudentService(StudentRepo studentRepo, CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }


    public Student addStudent(Student student){
        if(null !=student){
            if(null==student.getName() ||student.getName().equals("")){
                throw new RequiredDataMissingException("Name should not be empty");
            }
            student.setCreateDate(Instant.now());
            student.setUpdateDate(Instant.now());
            return studentRepo.save(student);
        }
        throw new RequiredDataMissingException("Student body can't be null");

    }

    public List<Student> getAllStudent(){
        return studentRepo.findAll();
    }
}
