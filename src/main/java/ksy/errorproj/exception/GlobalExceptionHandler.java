package ksy.errorproj.exception;

import ksy.errorproj.domain.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(OrderIdEmptyException.class)
    protected ResponseEntity<ErrorResponse> OrderIdEmptyExceptionHandler(OrderIdEmptyException e){
        final ErrorResponse errorResponse = ErrorResponse.builder()
                                                         .code(HttpStatus.BAD_REQUEST.value())
                                                         .message(e.getMessage()).build();

        return ResponseEntity.badRequest().body(errorResponse);
    }


    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<ErrorResponse> IllegalArgumentExceptionHandler(IllegalArgumentException e){
        final ErrorResponse errorResponse = ErrorResponse.builder()
                                                         .code(HttpStatus.BAD_REQUEST.value())
                                                         .message(e.getMessage()).build();


        return ResponseEntity.badRequest().body(errorResponse);
    }
}
