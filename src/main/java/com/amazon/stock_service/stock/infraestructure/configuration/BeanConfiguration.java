package com.amazon.stock_service.stock.infraestructure.configuration;

import com.amazon.stock_service.stock.domain.api.ICategoryServicePort;
import com.amazon.stock_service.stock.domain.spi.ICategoryPersistencePort;
import com.amazon.stock_service.stock.domain.api.usecase.CategoryUseCase;
import com.amazon.stock_service.stock.port.persistence.mysql.adapter.CategoryAdapter;
import com.amazon.stock_service.stock.port.persistence.mysql.mapper.CategoryEntityMapper;
import com.amazon.stock_service.stock.port.persistence.mysql.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ICategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Bean
    public ICategoryPersistencePort categoryPersistencePort(){
        return new CategoryAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public ICategoryServicePort categoryServicePort(){
        return new CategoryUseCase(categoryPersistencePort());
    }

}
