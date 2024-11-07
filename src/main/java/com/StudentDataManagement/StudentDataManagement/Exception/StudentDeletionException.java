package com.StudentDataManagement.StudentDataManagement.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class StudentDeletionException extends RuntimeException {
    public StudentDeletionException(String message) {
        super(message);
    }
}
