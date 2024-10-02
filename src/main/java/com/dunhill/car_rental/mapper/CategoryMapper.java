package com.dunhill.car_rental.mapper;

import com.dunhill.car_rental.Dtos.CreateCategoryDto;
import com.dunhill.car_rental.Dtos.ResponseCategoryDto;
import com.dunhill.car_rental.Entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category mapToEntity(CreateCategoryDto createCategoryDto) {

        Category category = new Category();
        category.setName(createCategoryDto.getName());
        category.setDescription(createCategoryDto.getDescription());
        return category;
    }

    public ResponseCategoryDto mapToDto(Category category) {
        ResponseCategoryDto responseCategoryDto = new ResponseCategoryDto();
        responseCategoryDto.setId(category.getId());
        responseCategoryDto.setName(category.getName());
        responseCategoryDto.setDescription(category.getDescription());

        return responseCategoryDto;
    }
}
