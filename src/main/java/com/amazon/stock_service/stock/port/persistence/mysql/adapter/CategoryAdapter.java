package com.amazon.stock_service.stock.port.persistence.mysql.adapter;

import com.amazon.stock_service.stock.domain.model.Category;
import com.amazon.stock_service.stock.domain.spi.ICategoryPersistencePort;
import com.amazon.stock_service.stock.domain.exception.CategoryAlreadyExistsException;
import com.amazon.stock_service.stock.port.persistence.mysql.mapper.CategoryEntityMapper;
import com.amazon.stock_service.stock.port.persistence.mysql.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CategoryAdapter implements ICategoryPersistencePort {

    private final ICategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;



    @Override
    public void saveCategory(Category category) {
        if (categoryRepository.findByName(category.getName()).isPresent() ){
            throw new CategoryAlreadyExistsException();
        }
        categoryRepository.save(categoryEntityMapper.toEntity(category));
    }

}
