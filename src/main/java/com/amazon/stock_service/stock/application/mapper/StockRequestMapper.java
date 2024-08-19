package com.amazon.stock_service.stock.application.mapper;

import com.amazon.stock_service.stock.application.dto.StockRequest;
import com.amazon.stock_service.stock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface StockRequestMapper {

    Category toCategory(StockRequest stockRequest);
}
