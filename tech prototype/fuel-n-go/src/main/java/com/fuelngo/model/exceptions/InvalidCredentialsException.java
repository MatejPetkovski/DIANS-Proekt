package com.fuelngo.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCredentialsException extends RuntimeException
{
    public InvalidCredentialsException() {
        super("Username or password is invalid, please try again");
    }
}
