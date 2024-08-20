package com.amazon.stock_service.stock.domain.spi;

import com.amazon.stock_service.stock.domain.model.Category;

public interface ICategoryPersistencePort {

    void saveCategory(Category category);

    void validateName(String name);

    void validateDescription(String description);
}
