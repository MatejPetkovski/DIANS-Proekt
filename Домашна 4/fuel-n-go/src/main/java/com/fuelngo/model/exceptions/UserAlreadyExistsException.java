package com.fuelngo.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String username) {
        super(String.format("Корисникот %s веќе постои.",username));
    }
}
