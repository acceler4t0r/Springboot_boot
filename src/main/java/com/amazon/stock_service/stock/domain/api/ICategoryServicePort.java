package com.amazon.stock_service.stock.domain.api;

import com.amazon.stock_service.stock.domain.model.Category;


public interface ICategoryServicePort {

    void saveCategory(Category category);

    void validateName(String name);

    void validateDescription(String description);
}
