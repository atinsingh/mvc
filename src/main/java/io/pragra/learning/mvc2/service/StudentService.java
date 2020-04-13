package io.pragra.learning.mvc2.service;

import io.pragra.learning.mvc2.domain.Course;
import io.pragra.learning.mvc2.domain.Student;
import io.pragra.learning.mvc2.exceptions.NotFoundException;
import io.pragra.learning.mvc2.exceptions.RequiredDataMissingException;
import io.pragra.learning.mvc2.repo.CourseRepo;
import io.pragra.learning.mvc2.repo.StudentRepo;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Student> saveAlll(List<Student> students){
        return studentRepo.saveAll(students);
    }

    public List<Student> getAllStudent(int limit){
        if(studentRepo.findAll().size()==0){
            throw new NotFoundException("No Data Found");
        }
        if(limit==0)
        return studentRepo.findAll();
        else {
            return studentRepo.findAll().stream().limit(limit).collect(Collectors.toList());
        }
    }

    public Student getStudentById(Long id) throws NotFoundException {
        Optional<Student> byId = studentRepo.findById(id);
        if(!byId.isPresent()){
            throw new NotFoundException("Student with id "+ id +" Doesn't exists");
        }
        return byId.get();
    }

    public Course signUp(Long courseId, Long studentId) throws NotFoundException{
        Optional<Course> byId = courseRepo.findById(courseId);
        studentRepo.findById(studentId).ifPresent(student -> {
            if(byId.isPresent()){
                student.getCourses().add(byId.get());
            }else{
                throw new NotFoundException("Course with id "+ courseId +"Doesn't exists");
            }
        });
        return byId.get();
    }
}
