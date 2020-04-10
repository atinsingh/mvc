package io.pragra.learning.mvc2.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@EqualsAndHashCode
@Data
@NoArgsConstructor
public class Course {
    @Id
    private Long id;

    @Column(unique = true)
    private String name;

    private String description;

    private Integer registeredCount;

}
