package com.student.registry.model;

import lombok.*;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@Embeddable
public class SubjectMark {

    private int english;
    private int maths;
    private int science;
    private int total;

}
