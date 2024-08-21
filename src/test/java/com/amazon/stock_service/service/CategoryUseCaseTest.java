package com.amazon.stock_service.service;

import com.amazon.stock_service.stock.domain.exception.CategoryValidationException;
import com.amazon.stock_service.stock.domain.exceptionhandler.category.ExceptionResponse;
import com.amazon.stock_service.stock.domain.model.Category;
import com.amazon.stock_service.stock.domain.api.usecase.CategoryUseCase;
import com.amazon.stock_service.stock.domain.spi.ICategoryPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CategoryUseCaseTest {

    @Mock
    private ICategoryPersistencePort categoryPersistencePort;
    @InjectMocks
    private CategoryUseCase categoryUseCase;

    @Test
    public void testSaveCategoryNameNull() {
        // Given

        Category category = new Category(2L, "", "Prueba2");

        // When/Then
        CategoryValidationException exception = assertThrows(CategoryValidationException.class, () -> {
            categoryUseCase.saveCategory(category);
        });

        assertEquals(ExceptionResponse.CATEGORY_NAME_NULL.getMessage(), exception.getMessage());
    }

    @Test
    public void testSaveCategoryNameLength() {
        // Given
        Category category = new Category(5L, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "Prueba3");

        // When/Then
        CategoryValidationException exception = assertThrows(CategoryValidationException.class, () -> {
            categoryUseCase.saveCategory(category);
        });

        assertEquals(ExceptionResponse.CATEGORY_NAME_LENGTH.getMessage(), exception.getMessage());
    }

    @Test
    public void testSaveCategoryDescriptionNull() {
        // Given
        Category category = new Category(2L, "Prueba4", "");

        // When/Then
        CategoryValidationException exception = assertThrows(CategoryValidationException.class, () -> {
            categoryUseCase.saveCategory(category);
        });

        assertEquals(ExceptionResponse.CATEGORY_DESCRIPTION_NULL.getMessage(), exception.getMessage());
    }

    @Test
    public void testSaveCategoryDescriptionLength() {
        // Given
        Category category = new Category(5L, "Prueba5", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        // When/Then
        CategoryValidationException exception = assertThrows(CategoryValidationException.class, () -> {
            categoryUseCase.saveCategory(category);
        });

        assertEquals(ExceptionResponse.CATEGORY_DESCRIPTION_LENGTH.getMessage(), exception.getMessage());
    }
}
