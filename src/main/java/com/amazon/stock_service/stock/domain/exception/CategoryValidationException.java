package com.amazon.stock_service.stock.domain.exception;

public class CategoryValidationException extends RuntimeException {
    public CategoryValidationException(String message) {
        super(message);
    }
}
