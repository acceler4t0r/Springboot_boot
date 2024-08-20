package com.amazon.stock_service.stock.port.application.handler;

import com.amazon.stock_service.stock.port.application.dto.StockRequest;

public interface IStockHandler {
    void saveCategoryInStock(StockRequest stockRequest);
}
