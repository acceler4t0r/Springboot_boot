package com.amazon.stock_service.mapper;

import com.amazon.stock_service.dto.CategoriaDto;
import com.amazon.stock_service.persistencia.entity.CategoriaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface CategoriaMapper {
    CategoriaDto categoriaDtoToCategoriaEntity(CategoriaEntity categoria);
    CategoriaEntity categoriaEntityToCategoriaDto(CategoriaDto categoria);
}
