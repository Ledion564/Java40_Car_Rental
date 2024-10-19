package com.dunhill.car_rental.controller;



import com.dunhill.car_rental.dtos.CreateCategoryDto;
import com.dunhill.car_rental.dtos.ResponseCategoryDto;
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

    private  CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ResponseCategoryDto> save(@RequestBody CreateCategoryDto createCategoryDto) {
        return new ResponseEntity<>(categoryService.save(createCategoryDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseCategoryDto>> getAll() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseCategoryDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseCategoryDto> update(@PathVariable Long id, @RequestBody CreateCategoryDto updateCategoryDto) {
        return ResponseEntity.ok(categoryService.update(id, updateCategoryDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


