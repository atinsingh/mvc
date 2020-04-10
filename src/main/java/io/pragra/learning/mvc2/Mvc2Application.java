package io.pragra.learning.mvc2;

import io.pragra.learning.mvc2.domain.Student;
import io.pragra.learning.mvc2.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Mvc2Application {

    private StudentService service;

    public Mvc2Application(StudentService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(Mvc2Application.class, args);
    }

    @Bean
    CommandLineRunner runner(){
        return args->{
            service.addStudent(new Student("Ajay"));
            service.addStudent(new Student("Alisha"));
        };
    }

}
