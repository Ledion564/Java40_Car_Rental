package com.dunhill.Car_Rental.service;


import com.dunhill.Car_Rental.Entity.Category;
import com.dunhill.Car_Rental.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryService {


    private CategoryRepository categoryRepository;



    public Category save(Category newCategory) {
     return categoryRepository.save(newCategory);
    }


    public List<Category> findAll() {
     return  categoryRepository.findAll();
    }




    }