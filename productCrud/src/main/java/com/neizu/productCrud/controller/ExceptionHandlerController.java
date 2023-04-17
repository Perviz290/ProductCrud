package com.neizu.productCrud.controller;

import com.neizu.productCrud.dto.response.ErrorResponse;
import com.neizu.productCrud.exception.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(IdNotFoundException.class)
    public ErrorResponse handleIdNotFoundException(IdNotFoundException e) {
        return ErrorResponse.builder()
                .message(e.getMessage())
                .errorCode(HttpStatus.NOT_FOUND)
                .build();
    }







}
