package com.fuelngo.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FuelStationNotFoundException extends RuntimeException{
    public FuelStationNotFoundException(Long id) {
        super(String.format("Бензинската %d не е пронајдена",id));
    }
}
