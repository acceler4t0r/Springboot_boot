package com.amazon.stock_service.stock.application.mapper;

import com.amazon.stock_service.stock.application.dto.StockResponse;
import com.amazon.stock_service.stock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface StockResponseMapper {
    StockResponse toResponse(Category category);

    default List<StockResponse> toResponseList(List<Category> categoryList){
        return categoryList
                .stream()
                .map(category -> {
                    StockResponse stockResponse = new StockResponse();
                    stockResponse.setId(category.getId());
                    stockResponse.setName(category.getName());
                    stockResponse.setDescription(category.getDescription());
                    return stockResponse;
                }).toList();
    }
}
