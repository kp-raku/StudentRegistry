package com.student.registry.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse {

    String errorMessage;
    String requestURI;
}
