package com.amazon.stock_service.stock.domain.api;

import com.amazon.stock_service.stock.domain.model.Category;

import java.util.List;

public interface ICategoryServicePort {

    void saveCategory(Category category);

}
