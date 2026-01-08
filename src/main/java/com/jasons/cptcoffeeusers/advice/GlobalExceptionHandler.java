package com.jasons.cptcoffeeusers.advice;

import com.jasons.cptcoffeeusers.exceptions.NotFoundException;
import com.jasons.cptcoffeeusers.model.ErrorResponse;
import com.jasons.cptcoffeeusers.model.ErrorResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseWrapper> notFoundException(NotFoundException ex){
        ErrorResponseWrapper wrapper = new ErrorResponseWrapper();
        ErrorResponse response = new ErrorResponse();

        response.setMessage("No data found");
        response.setDetails(ex.getMessage());

        wrapper.setData(null);
        wrapper.setError(response);

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(wrapper);
    }
}
