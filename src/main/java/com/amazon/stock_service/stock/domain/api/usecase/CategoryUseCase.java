package com.amazon.stock_service.stock.domain.api.usecase;

import com.amazon.stock_service.stock.domain.api.ICategoryServicePort;
import com.amazon.stock_service.stock.domain.exception.CategoryValidationException;
import com.amazon.stock_service.stock.domain.exceptionhandler.category.ExceptionResponse;
import com.amazon.stock_service.stock.domain.model.Category;
import com.amazon.stock_service.stock.domain.spi.ICategoryPersistencePort;


public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort){
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(Category category){
        validateName(category.getName());
        validateDescription(category.getDescription());
        categoryPersistencePort.saveCategory(category);
    }

    @Override
    public void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new CategoryValidationException(ExceptionResponse.CATEGORY_NAME_NULL.getMessage());
        }
        if (name.length() > 50) {
            throw new CategoryValidationException(ExceptionResponse.CATEGORY_NAME_LENGTH.getMessage());
        }
    }

    @Override
    public void validateDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new CategoryValidationException(ExceptionResponse.CATEGORY_DESCRIPTION_NULL.getMessage());
        }
        if (description.length() > 90){
            throw new CategoryValidationException(ExceptionResponse.CATEGORY_DESCRIPTION_LENGTH.getMessage());
        }

    }
}
