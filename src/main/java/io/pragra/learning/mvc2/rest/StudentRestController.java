package io.pragra.learning.mvc2.rest;

import io.pragra.learning.mvc2.Error;
import io.pragra.learning.mvc2.domain.Student;
import io.pragra.learning.mvc2.exceptions.NotFoundException;
import io.pragra.learning.mvc2.service.StudentService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private StudentService service;

    public StudentRestController(StudentService service) {
        this.service = service;
    }

    @GetMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllStudent(@RequestParam(name = "limit", defaultValue = "0" ,required = false) int limit){
        try {
            List<Student>students = service.getAllStudent(limit);
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-Reponder","Atin");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .headers(headers)
                    .body(students);
        }catch (NotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                    .body(new
                    Error("404", ex.getMessage(), Instant.now()));
        }
    }

    @PostMapping(value = "/student",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        if(student==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Error("400","Empty Body please check", Instant.now())
            );
        }
        return ResponseEntity.accepted().body(service.addStudent(student));
    }

    @PostMapping("/students")
    public List<Student> saveAllStudent(@RequestBody List<Student> students){
        return service.saveAlll(students);
    }

    @GetMapping(value = "/student/{id}")
    public Student getStudentById(@PathVariable ("id") Long id)  {
        return service.getStudentById(id);
    }
}
