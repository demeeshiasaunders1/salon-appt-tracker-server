package com.saundersdemeeshia.salonappointmenttracker.domain.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) //this is built in by Spring and will catch and throw error 404 (not found)
public class ResourceNotFoundException extends RuntimeException{ //extends from runtime exception bc they are unchecked
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

