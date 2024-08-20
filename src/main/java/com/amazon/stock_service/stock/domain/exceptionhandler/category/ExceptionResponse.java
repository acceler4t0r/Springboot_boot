package com.amazon.stock_service.stock.domain.exceptionhandler.category;

public enum ExceptionResponse {
    CATEGORY_NOT_FOUND("No category was found with that id"),
    CATEGORY_ALREADY_EXISTS("There is already a category with that name"),
    NO_DATA_FOUND("No data found for the requested petition");
    private String message;

    ExceptionResponse(String message){
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
