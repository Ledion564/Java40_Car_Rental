package com.dunhill.car_rental.mapper;

import com.dunhill.car_rental.dtos.CreateCategoryDto;
import com.dunhill.car_rental.dtos.ResponseCategoryDto;
import com.dunhill.car_rental.entity.Category;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CategoryMapper {

    public Category mapToEntity(CreateCategoryDto createCategoryDto) {

        Category category = new Category();
        category.setUsername(createCategoryDto.getName());
        category.setDescription(createCategoryDto.getDescription());
        category.setCategoryType(createCategoryDto.getCategoryType());
        category.setPriority(createCategoryDto.getPriority());
        category.setRating(createCategoryDto.getRating());
        category.setCreatedBy(createCategoryDto.getCreatedBy());
        category.setCreatedAt(LocalDateTime.now());
        category.setActive(true);
        return category;
    }

    public ResponseCategoryDto mapToDto(Category category) {
        ResponseCategoryDto responseCategoryDto = new ResponseCategoryDto();
        responseCategoryDto.setId(category.getId());
        responseCategoryDto.setName(category.getUsername());
        responseCategoryDto.setDescription(category.getDescription());
        responseCategoryDto.setCategoryType(category.getCategoryType());
        responseCategoryDto.setPriority(category.getPriority());
        responseCategoryDto.setRating(category.getRating());
        responseCategoryDto.setCreatedBy(category.getCreatedBy());
        responseCategoryDto.setCreatedAt(category.getCreatedAt());
        responseCategoryDto.setUpdatedAt(category.getUpdatedAt());
        responseCategoryDto.setActive(category.isActive());

        return responseCategoryDto;
    }

    public Category update(CreateCategoryDto createCategoryDto, Category category){
        category.setUsername(createCategoryDto.getName());
        category.setDescription(createCategoryDto.getDescription());
        category.setCategoryType(createCategoryDto.getCategoryType());
        category.setPriority(createCategoryDto.getPriority());
        category.setRating(createCategoryDto.getRating());
        category.setUpdatedAt(LocalDateTime.now());
        category.setActive(createCategoryDto.isActive());

        return category;
    }
}
