package com.student.registry.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StudentNotFoundException extends Exception{
    public StudentNotFoundException(String message) {
        super(message);
    }
}
