package com.amazon.stock_service.service;

import com.amazon.stock_service.DataProviderTest;
import com.amazon.stock_service.stock.domain.exception.CategoryValidationException;
import com.amazon.stock_service.stock.domain.model.Category;
import com.amazon.stock_service.stock.port.persistence.mysql.adapter.CategoryAdapter;
import com.amazon.stock_service.stock.port.persistence.mysql.entity.CategoryEntity;
import com.amazon.stock_service.stock.port.persistence.mysql.mapper.CategoryEntityMapper;
import com.amazon.stock_service.stock.port.persistence.mysql.repository.ICategoryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CategoryAdapterTest {

    @Test
    public void testSaveCategory() {
        // Given
        ICategoryRepository categoryRepository = mock(ICategoryRepository.class);
        CategoryEntityMapper categoryEntityMapper = mock(CategoryEntityMapper.class);
        CategoryAdapter categoryAdapter = new CategoryAdapter(categoryRepository, categoryEntityMapper);

        // Iterate over all categories in the mock list
        for (Category category : DataProviderTest.categoryListMock()) {
            // Reset the mock's interactions before each iteration
            Mockito.reset(categoryRepository);

            if (category.getName() == null || category.getName().isBlank() || category.getName().length() > 50 ||
                    category.getDescription() == null || category.getDescription().isBlank() || category.getDescription().length() > 90) {

                // Expect validation exceptions for invalid categories
                assertThrows(CategoryValidationException.class, () -> categoryAdapter.saveCategory(category));

                // Ensure that the repository's save method is never called for invalid categories
                verify(categoryRepository, never()).save(any());
            } else {
                // When category is valid, simulate the repository and mapper behavior
                when(categoryRepository.findByName(category.getName())).thenReturn(Optional.empty());
                when(categoryEntityMapper.toEntity(category)).thenReturn(new CategoryEntity()); // Create a mock entity

                // Call the method
                assertDoesNotThrow(() -> categoryAdapter.saveCategory(category));

                // Verify that save was called exactly once for valid categories
                verify(categoryRepository, times(1)).save(any(CategoryEntity.class));
            }
        }
    }
}
