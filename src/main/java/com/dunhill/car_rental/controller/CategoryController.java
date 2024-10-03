package com.dunhill.car_rental.controller;



import com.dunhill.car_rental.Dtos.CreateCategoryDto;
import com.dunhill.car_rental.Dtos.ResponseCategoryDto;
import com.dunhill.car_rental.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/category")
@RestController
public class CategoryController {

    private CategoryService categoryService;


    @PostMapping
    public ResponseEntity<ResponseCategoryDto> save(@RequestBody CreateCategoryDto createCategoryDto) {
      return ResponseEntity.ok(categoryService.save(createCategoryDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResponseCategoryDto>> getAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    @PutMapping
    public ResponseEntity<ResponseCategoryDto> update(@RequestBody CreateCategoryDto createCategoryDto){
        return ResponseEntity.ok(categoryService.update(createCategoryDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam("cId") Long id){
        categoryService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

