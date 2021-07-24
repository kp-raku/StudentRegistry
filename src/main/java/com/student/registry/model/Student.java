package com.student.registry.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "studentData")
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long studentId;

    private String name;

    private SubjectMark mark;

}
