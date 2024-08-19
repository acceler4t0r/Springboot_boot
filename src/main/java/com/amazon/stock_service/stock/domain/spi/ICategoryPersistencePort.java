package com.amazon.stock_service.stock.domain.spi;

import com.amazon.stock_service.stock.domain.model.Category;

import java.util.List;

public interface ICategoryPersistencePort {

    void saveCategory(Category category);
}
