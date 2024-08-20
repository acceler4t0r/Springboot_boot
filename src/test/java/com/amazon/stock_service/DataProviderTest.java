package com.amazon.stock_service;

import com.amazon.stock_service.stock.domain.model.Category;

import java.util.List;

public class DataProviderTest {

    public static List<Category> categoryListMock() {
        System.out.println("-> Prueba unitaria");

        return List.of(
                new Category(1L,"Prueba1", "Prueba1"),
                new Category(2L,"Prueba2","Prueba2"),
                new Category(3L,"","Prueba3"),
                new Category(4L,"Prueba4",""),
                new Category(5L,"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","Prueba5"),
                new Category(6L,"Prueba6","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
        );
    }
}
