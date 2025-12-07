package com.example.demo.adapter.web;

import com.example.demo.domain.exception.DuplicateNimException;
import com.example.demo.domain.exception.StudentNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    record ApiError(
            Instant timestamp,
            int status,
            String error,
            String message,
            String path,
            Map<String, String> fieldErrors
    ) {}

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(
            StudentNotFoundException e,
            HttpServletRequest req
    ) {
        return buildError(HttpStatus.NOT_FOUND, e.getMessage(), req, null);
    }

    @ExceptionHandler(DuplicateNimException.class)
    public ResponseEntity<ApiError> handleConflict(
            DuplicateNimException e,
            HttpServletRequest req
    ) {
        return buildError(HttpStatus.CONFLICT, e.getMessage(), req, null);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleIllegalArgument(
            IllegalArgumentException e,
            HttpServletRequest req
    ) {
        return buildError(HttpStatus.BAD_REQUEST, e.getMessage(), req, null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(
            MethodArgumentNotValidException e,
            HttpServletRequest req
    ) {
        Map<String, String> fieldErrors = new LinkedHashMap<>();
        for (FieldError fe : e.getBindingResult().getFieldErrors()) {
            fieldErrors.put(fe.getField(), fe.getDefaultMessage());
        }
        return buildError(HttpStatus.BAD_REQUEST, "Validation failed", req, fieldErrors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> handleBadJson(
            HttpMessageNotReadableException e,
            HttpServletRequest req
    ) {
        return buildError(
                HttpStatus.BAD_REQUEST,
                "Invalid JSON or date format (use YYYY-MM-DD)",
                req,
                null
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneric(
            Exception e,
            HttpServletRequest req
    ) {
        e.printStackTrace();
        return buildError(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Unexpected server error",
                req,
                null
        );
    }

    private ResponseEntity<ApiError> buildError(
            HttpStatus status,
            String message,
            HttpServletRequest req,
            Map<String, String> fieldErrors
    ) {
        return ResponseEntity.status(status).body(
                new ApiError(
                        Instant.now(),
                        status.value(),
                        status.getReasonPhrase(),
                        message,
                        req.getRequestURI(),
                        fieldErrors
                )
        );
    }
}