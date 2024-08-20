package com.amazon.stock_service.stock.domain.exceptionhandler.category;

public enum ExceptionResponse {
    CATEGORY_NOT_FOUND("No category was found with that id"),
    CATEGORY_ALREADY_EXISTS("There is already a category with that name"),
    CATEGORY_NAME_NULL("Name is mandatory"),
    CATEGORY_DESCRIPTION_NULL("Description is mandatory"),
    CATEGORY_NAME_LENGTH("Name must be less than or equal to 50 characters"),
    CATEGORY_DESCRIPTION_LENGTH("Description must be less than or equal to 90 characters"),
    NO_DATA_FOUND("No data found for the requested petition");
    private String message;

    ExceptionResponse(String message){
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
