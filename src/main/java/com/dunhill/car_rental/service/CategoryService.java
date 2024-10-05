package com.dunhill.car_rental.service;


import com.dunhill.car_rental.Dtos.CreateCategoryDto;
import com.dunhill.car_rental.Dtos.ResponseCategoryDto;
import com.dunhill.car_rental.Entity.Category;
import com.dunhill.car_rental.Exceptions.NotFoundException;
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


    public List<ResponseCategoryDto> findAll() {
     return  categoryRepository.findAll().stream()
             .map(categoryMapper::mapToDto)
             .toList();
    }

    public void delete(long id){
        Category found = categoryRepository.findById(id).
                orElseThrow(()-> new NotFoundException("Cannot find this category!"));
        categoryRepository.delete(found);
    }

//    public ResponseCategoryDto update(CreateCategoryDto createCategoryDto){
////        Category found = categoryRepository.findByName(createCategoryDto.getName());
//        found = categoryMapper.update(createCategoryDto, found);
//
//        return categoryMapper.mapToDto(categoryRepository.save(found));
//    }




    }