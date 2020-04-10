package io.pragra.learning.mvc2.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(targetEntity = Course.class, cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

    private Instant createDate;

    private Instant updateDate;

    public Student(String name) {
        this.name = name;
    }
}
