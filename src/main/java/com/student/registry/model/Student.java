package com.student.registry.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name = "studentData")
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long studentId;

    @Size(min = 4,message = "Name must be min 4 Characters")
    private String name;

    private SubjectMark mark;

}
