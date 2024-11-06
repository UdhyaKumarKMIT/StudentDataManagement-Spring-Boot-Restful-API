package com.StudentDataManagement.StudentDataManagement.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StudentCreationException extends RuntimeException {
    public StudentCreationException(String message) {
        super(message);
    }
}
