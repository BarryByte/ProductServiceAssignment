package com.example.productserviceassignment.exceptionhandlers;

import com.example.productserviceassignment.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity handleArithimeticException(){
        System.out.println("Arithmetic Exception Occured");
        ExceptionDto dto = new ExceptionDto();
        dto.setResolution("Please check the input");
        dto.setMessage("Arithmetic Exception Occured");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto, HttpStatus.GONE);
        return response;
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity handleArrayIndexOutOfBoundsException(){
        System.out.println("ArrayIndexOutOfBound Exception Occured");
        ExceptionDto dto = new ExceptionDto();
        dto.setResolution("Please check the indexes");
        dto.setMessage("ArrayIndexOutOfBoundsException Exception Occured");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto, HttpStatus.GONE);
        return response;
    }

}
