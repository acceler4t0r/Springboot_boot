package com.amazon.stock_service.persistencia.repository;

import com.amazon.stock_service.persistencia.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}


