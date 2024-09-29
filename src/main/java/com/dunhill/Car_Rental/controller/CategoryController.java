package com.dunhill.Car_Rental.controller;


import com.dunhill.Car_Rental.Dtos.CreateCategoryDto;
import com.dunhill.Car_Rental.Dtos.ResponseCategoryDto;
import com.dunhill.Car_Rental.Entity.Category;
import com.dunhill.Car_Rental.repository.CategoryRepository;
import com.dunhill.Car_Rental.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/category")
@RestController
public class CategoryController {

    private CategoryService categoryService;
    @PostMapping
    public ResponseCategoryDto save(@RequestBody CreateCategoryDto createCategoryDto) {
      return  categoryService.save(createCategoryDto);
    }

}

