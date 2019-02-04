package com.michi.imdbservice.requests.advices;

import com.michi.imdbservice.services.OmdbConnectionException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class OmdbConnectionAdvice {

    @ResponseBody
    @ExceptionHandler(OmdbConnectionException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String omdbConnectionHandler(OmdbConnectionException e) {
        return e.getMessage();
    }

}
