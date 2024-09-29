package com.dunhill.Car_Rental.mapper;

import com.dunhill.Car_Rental.Dtos.CreateCategoryDto;
import com.dunhill.Car_Rental.Dtos.ResponseCategoryDto;
import com.dunhill.Car_Rental.Entity.Category;
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
