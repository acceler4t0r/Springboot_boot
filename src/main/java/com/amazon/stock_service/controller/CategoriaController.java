package com.amazon.stock_service.controller;


import com.amazon.stock_service.dto.CategoriaDto;
import com.amazon.stock_service.mapper.CategoriaMapper;
import com.amazon.stock_service.persistencia.entity.CategoriaEntity;
import com.amazon.stock_service.persistencia.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor

public class CategoriaController {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    @GetMapping("/index")
    private List<CategoriaDto> obtenerCategoria() {
        return categoriaRepository
                .findAll()
                .stream()
                .map(categoriaEntity -> categoriaMapper.categoriaDtoToCategoriaEntity(categoriaEntity))
                .collect(Collectors.toList());
    }

}
