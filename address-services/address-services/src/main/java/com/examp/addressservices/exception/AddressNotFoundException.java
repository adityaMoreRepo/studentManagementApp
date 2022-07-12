package com.examp.addressservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AddressNotFoundException extends RuntimeException{
    public static final long serialVersionId = 1L;
    public AddressNotFoundException(String err){
        super(err);
    }
}
