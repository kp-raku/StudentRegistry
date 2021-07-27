package com.student.registry.model;

import lombok.*;
import org.hibernate.validator.constraints.Range;


import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@Embeddable
public class SubjectMark {

    @Range(min=10, max=50)
    private int english;
    private int maths;
    private int science;
    private int total;

}
