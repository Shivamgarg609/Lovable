package com.shivam.projects.lovable_clone.error;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequest(BadRequestException ex){
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,ex.getMessage());
        log.error(apiError.toString(),ex);
        return ResponseEntity.status(apiError.httpStatus()).body(apiError);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFound(ResourceNotFoundException ex){
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,ex.getResourceName() + "withId" + ex.getResourceID());
        log.error(apiError.toString(),ex);
        return ResponseEntity.status(apiError.httpStatus()).body(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleInputValidationException(MethodArgumentNotValidException ex){

       List<ApiFieldError> errors = ex.getBindingResult().getFieldErrors()
                                      .stream()
                                      .map(error -> new ApiFieldError(error.getField(),error.getDefaultMessage())).toList();
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,"Input Validation failed",errors);
        log.error(apiError.toString(),ex);
        return ResponseEntity.status(apiError.httpStatus()).body(apiError);
    }
}
