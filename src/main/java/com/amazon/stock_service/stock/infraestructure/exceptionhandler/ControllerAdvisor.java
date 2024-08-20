package com.amazon.stock_service.stock.infraestructure.exceptionhandler;

import com.amazon.stock_service.stock.domain.exception.CategoryValidationException;
import com.amazon.stock_service.stock.domain.exceptionhandler.category.ExceptionResponse;
import com.amazon.stock_service.stock.domain.exception.CategoryAlreadyExistsException;
import com.amazon.stock_service.stock.domain.exception.CategoryNotFoundException;
import com.amazon.stock_service.stock.domain.exception.NoDataFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = "Message";

    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleCategoryAlreadyExistsException(
            CategoryAlreadyExistsException categoryAlreadyExistsException){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.CATEGORY_ALREADY_EXISTS.getMessage()));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            NoDataFoundException noDataFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoCategoryFoundException(
            CategoryNotFoundException categoryNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.CATEGORY_NOT_FOUND.getMessage()));
    }

    @ExceptionHandler(CategoryValidationException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(
            CategoryValidationException categoryValidationException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, categoryValidationException.getMessage()));
    }

    @ExceptionHandler(EmptyFieldException.class)
    public ResponseEntity<Map<String, String>> handleEmptyFieldException(
            EmptyFieldException emptyFieldException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, emptyFieldException.getMessage()));
    }

}
