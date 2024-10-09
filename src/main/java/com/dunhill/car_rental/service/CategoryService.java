package com.dunhill.car_rental.service;


import com.dunhill.car_rental.Dtos.CreateCategoryDto;
import com.dunhill.car_rental.Dtos.ResponseCategoryDto;
import com.dunhill.car_rental.Entity.Category;
import com.dunhill.car_rental.mapper.CategoryMapper;
import com.dunhill.car_rental.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
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
        return categoryMapper.mapToDto(savedCategory);
    }


    public List<ResponseCategoryDto> findAll() {
     return  categoryRepository.findAll().stream().map(category -> categoryMapper.mapToDto(category)).toList();
    }

    public ResponseCategoryDto findById(Long id) {
        return categoryMapper.mapToDto(categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found")));
    }

    public ResponseCategoryDto update(Long id, CreateCategoryDto createCategoryDto) {
        Category category = categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found"));
        category.setUsername(createCategoryDto.getName());;
        category.setDescription(createCategoryDto.getDescription());
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.mapToDto(savedCategory);
    }

    public void delete(Long id) {
        Category foundCategory = categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found"));
        categoryRepository.delete(foundCategory);
    }

}