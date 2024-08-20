package com.amazon.stock_service.stock.port.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockRequest {
    private String name;
    private String description;
}
