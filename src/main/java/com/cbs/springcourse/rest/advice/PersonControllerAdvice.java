package com.cbs.springcourse.rest.advice;

import com.cbs.springcourse.rest.models.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.NoSuchElementException;

//@ControllerAdvice
//public class PersonControllerAdvice extends ResponseEntityExceptionHandler {
//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<Error> handleNoSuchElementException(
//            NoSuchElementException runtimeException,
//            WebRequest request
//    ) {
//        return new ResponseEntity<>(
//                new Error(List.of("User not found")),
//                HttpStatus.NOT_FOUND
//        );
//    }
//}
