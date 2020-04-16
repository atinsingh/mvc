package io.pragra.learning.mvc2.rest;

import io.pragra.lms.model.StudentInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentInfoController implements io.pragra.lms.rest.StudentinfoApi {

    @Override
    public ResponseEntity<StudentInfo> studentinfoGet() {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setId(93988383L);
        studentInfo.setName("AKDHJKDKJDKJD");
        return ResponseEntity.status(200).body(studentInfo);
    }
}
