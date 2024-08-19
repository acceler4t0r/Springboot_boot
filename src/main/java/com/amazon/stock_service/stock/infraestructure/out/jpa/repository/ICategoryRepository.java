package com.amazon.stock_service.stock.infraestructure.out.jpa.repository;

import com.amazon.stock_service.stock.infraestructure.out.jpa.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {

    Optional<CategoryEntity> findByName(String categoryName);

}
