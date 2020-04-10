package io.pragra.learning.mvc2;

import io.pragra.learning.mvc2.domain.Student;
import io.pragra.learning.mvc2.exceptions.RequiredDataMissingException;
import io.pragra.learning.mvc2.service.StudentService;
import static  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class Mvc2ApplicationTests {
    @Autowired
    private StudentService service;
    @Test
    void contextLoads() {
    }

    @Test()
    public void addStudentTest(){
        Student student = new Student();
        assertThrows(RequiredDataMissingException.class, ()->{
            service.addStudent(student);
        });
    }

    @Test()
    public void addStudentTestEmptyString(){
        Student student = new Student();
        student.setName("");
       Exception ex = assertThrows(RequiredDataMissingException.class, ()->{
            service.addStudent(student);
        });
       assertEquals("Name should not be empty", ex.getMessage());
    }

    @Test
    public void getStudentTC(){
        service.addStudent(new Student("Vivek"));
        List<Student> allStudent = service.getAllStudent();
        assertTrue(allStudent.size()>=1);
        Student student = allStudent.get(0);
        assertTrue(student.getCreateDate()!=null);

    }


}
