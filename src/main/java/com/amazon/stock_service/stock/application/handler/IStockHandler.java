package com.amazon.stock_service.stock.application.handler;

import com.amazon.stock_service.stock.application.dto.StockRequest;
import com.amazon.stock_service.stock.application.dto.StockResponse;

import java.util.List;

public interface IStockHandler {
    void saveCategoryInStock(StockRequest stockRequest);
}
