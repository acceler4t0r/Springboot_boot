package com.amazon.stock_service.stock.application.handler;

import com.amazon.stock_service.stock.application.dto.StockRequest;
import com.amazon.stock_service.stock.application.dto.StockResponse;
import com.amazon.stock_service.stock.application.mapper.StockRequestMapper;
import com.amazon.stock_service.stock.application.mapper.StockResponseMapper;
import com.amazon.stock_service.stock.domain.api.ICategoryServicePort;
import com.amazon.stock_service.stock.domain.model.Category;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StockHandler implements IStockHandler{

    private final ICategoryServicePort categoryServicePort;
    private final StockRequestMapper stockRequestMapper;
    private StockResponseMapper stockResponseMapper;

    @Override
    public void saveCategoryInStock(StockRequest stockRequest) {
        Category category = stockRequestMapper.toCategory(stockRequest);
        categoryServicePort.saveCategory(category);
    }
}
