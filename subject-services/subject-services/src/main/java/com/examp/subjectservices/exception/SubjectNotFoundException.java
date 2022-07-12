package com.examp.subjectservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SubjectNotFoundException extends Exception{
    public SubjectNotFoundException(String err){
        super(err);
    }
}
