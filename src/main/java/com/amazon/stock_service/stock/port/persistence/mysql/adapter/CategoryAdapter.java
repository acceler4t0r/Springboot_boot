package com.amazon.stock_service.stock.port.persistence.mysql.adapter;

import com.amazon.stock_service.stock.domain.exception.CategoryValidationException;
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
        String name = category.getName();
        validateName(name);
        validateDescription(category.getDescription());
        if (categoryRepository.findByName(name).isPresent() ){
            throw new CategoryAlreadyExistsException();
        }
        categoryRepository.save(categoryEntityMapper.toEntity(category));
    }

    @Override
    public void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new CategoryValidationException("Name is mandatory");
        }
        if (name.length() > 50) {
            throw new CategoryValidationException("Name must be less than or equal to 50 characters");
        }
    }

    @Override
    public void validateDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new CategoryValidationException("Description is mandatory must be less than or equal to 200 characters");
        }
        if (description.length() > 90){
            throw new CategoryValidationException("Description must be less than or equal to 90 characters");
        }

    }

}
