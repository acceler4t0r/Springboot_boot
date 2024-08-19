package com.amazon.stock_service.stock.infraestructure.out.jpa.mapper;

import com.amazon.stock_service.stock.domain.model.Category;
import com.amazon.stock_service.stock.infraestructure.out.jpa.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoryEntityMapper {

    CategoryEntity toEntity(Category category);

    Category toCategory(CategoryEntity categoryEntity);

    List<Category> toCategoryList(List<CategoryEntity> categoryEntityList);

}
