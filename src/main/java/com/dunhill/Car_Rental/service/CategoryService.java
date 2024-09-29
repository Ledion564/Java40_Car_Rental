package com.dunhill.Car_Rental.service;


import com.dunhill.Car_Rental.Dtos.CreateCategoryDto;
import com.dunhill.Car_Rental.Dtos.ResponseCategoryDto;
import com.dunhill.Car_Rental.Entity.Category;
import com.dunhill.Car_Rental.mapper.CategoryMapper;
import com.dunhill.Car_Rental.repository.CategoryRepository;
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