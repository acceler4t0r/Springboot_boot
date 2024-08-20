package com.amazon.stock_service.stock.port.application.mapper.category;

import com.amazon.stock_service.stock.port.application.dto.StockResponse;
import com.amazon.stock_service.stock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoryResponseMapper {
    StockResponse toResponse(Category category);

    default List<StockResponse> toResponseList(List<Category> categoryList){
        return categoryList
                .stream()
                .map(category -> {
                    StockResponse stockResponse = new StockResponse();
                    stockResponse.setName(category.getName());
                    stockResponse.setDescription(category.getDescription());
                    return stockResponse;
                }).toList();
    }
}
