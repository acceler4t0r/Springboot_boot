package com.amazon.stock_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CategoriaDto {
    private Long cat_id;
    private String cat_nombre;
    private String cat_descripcion;
}
