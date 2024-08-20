package com.amazon.stock_service.stock.port.application.handler;

import com.amazon.stock_service.stock.domain.api.ICategoryServicePort;
import com.amazon.stock_service.stock.port.application.dto.StockRequest;
import com.amazon.stock_service.stock.domain.model.Category;
import com.amazon.stock_service.stock.port.application.mapper.category.CategoryRequestMapper;
import com.amazon.stock_service.stock.port.application.mapper.category.CategoryResponseMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class StockHandler implements IStockHandler{

    private final ICategoryServicePort categoryServicePort;
    private final CategoryRequestMapper stockRequestMapper;
    private CategoryResponseMapper stockResponseMapper;

    @Override
    public void saveCategoryInStock(StockRequest stockRequest) {
        Category category = stockRequestMapper.toCategory(stockRequest);
        categoryServicePort.saveCategory(category);
    }
}
