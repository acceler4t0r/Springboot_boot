package com.amazon.stock_service.stock.domain.api.usecase;

import com.amazon.stock_service.stock.domain.api.ICategoryServicePort;
import com.amazon.stock_service.stock.domain.model.Category;
import com.amazon.stock_service.stock.domain.spi.ICategoryPersistencePort;

import java.util.List;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort){
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(Category category){
        categoryPersistencePort.saveCategory(category);
    }

}
