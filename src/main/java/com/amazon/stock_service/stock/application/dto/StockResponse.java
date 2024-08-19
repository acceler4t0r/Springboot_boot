package com.amazon.stock_service.stock.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockResponse {
    private Long id;
    private String name;
    private String description;
}
