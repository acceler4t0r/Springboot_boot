package com.amazon.stock_service.service;

import com.amazon.stock_service.stock.domain.exception.CategoryAlreadyExistsException;
import com.amazon.stock_service.stock.domain.exceptionhandler.category.ExceptionResponse;
import com.amazon.stock_service.stock.domain.model.Category;
import com.amazon.stock_service.stock.port.persistence.mysql.adapter.CategoryAdapter;
import com.amazon.stock_service.stock.port.persistence.mysql.entity.CategoryEntity;
import com.amazon.stock_service.stock.port.persistence.mysql.mapper.CategoryEntityMapper;
import com.amazon.stock_service.stock.port.persistence.mysql.repository.ICategoryRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CategoryAdapterTest {

    @Mock
    private ICategoryRepository categoryRepository;
    @Mock
    private CategoryEntityMapper categoryEntityMapper;
    @InjectMocks
    private CategoryAdapter categoryAdapter;


    @Test
    public void testSaveCategorySuccess() {
        // Given

        Category category = new Category(1L, "Prueba1", "Prueba1");

        when(categoryRepository.findByName("Prueba1")).thenReturn(Optional.empty());
        when(categoryEntityMapper.toEntity(category)).thenReturn(new CategoryEntity());

        // When
        categoryAdapter.saveCategory(category);

        // Then
        verify(categoryRepository).save(any(CategoryEntity.class));
    }

    @Test
    public void testSaveCategoryNameExist() {
        // Given
        Category category = new Category(1L, "Prueba1", "Prueba1");

        when(categoryRepository.findByName("Prueba1")).thenReturn(Optional.of(new CategoryEntity()));

        // When/Then
        CategoryAlreadyExistsException thrown = assertThrows(CategoryAlreadyExistsException.class, () -> {
            categoryAdapter.saveCategory(category);
        });

        assertEquals(ExceptionResponse.CATEGORY_ALREADY_EXISTS.getMessage(), thrown.getMessage());
    }
}
