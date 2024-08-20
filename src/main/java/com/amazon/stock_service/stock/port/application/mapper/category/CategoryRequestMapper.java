package com.amazon.stock_service.stock.port.application.mapper.category;

import com.amazon.stock_service.stock.port.application.dto.StockRequest;
import com.amazon.stock_service.stock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoryRequestMapper {

    Category toCategory(StockRequest stockRequest);
}
