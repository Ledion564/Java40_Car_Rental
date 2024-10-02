package com.dunhill.car_rental.controller;



import com.dunhill.car_rental.Dtos.CreateCategoryDto;
import com.dunhill.car_rental.Dtos.ResponseCategoryDto;
import com.dunhill.car_rental.service.CategoryService;
import lombok.AllArgsConstructor;
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

