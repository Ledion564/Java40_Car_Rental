package com.dunhill.car_rental.service;


import com.dunhill.car_rental.Dtos.CreateCategoryDto;
import com.dunhill.car_rental.Dtos.ResponseCategoryDto;
import com.dunhill.car_rental.Entity.Category;
import com.dunhill.car_rental.mapper.CategoryMapper;
import com.dunhill.car_rental.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryService {


    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;



    public ResponseCategoryDto save(CreateCategoryDto createCategoryDto) {
     Category newCategory = categoryMapper.mapToEntity(createCategoryDto);
     Category savedCategory = categoryRepository.save(newCategory);
     ResponseCategoryDto responseCategoryDto = categoryMapper.mapToDto(savedCategory);

     return responseCategoryDto;
    }


    public List<Category> findAll() {
     return  categoryRepository.findAll();
    }




    }