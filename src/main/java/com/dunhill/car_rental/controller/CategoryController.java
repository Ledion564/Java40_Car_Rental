package com.dunhill.car_rental.controller;



import com.dunhill.car_rental.dtos.CreateCategoryDto;
import com.dunhill.car_rental.dtos.ResponseCategoryDto;
import com.dunhill.car_rental.service.CategoryService;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/category")
@RestController
@Tag(name = "CRUD REST APIs for Category Resource")
public class CategoryController {

    private  CategoryService categoryService;

    @Operation(summary = "Create Category REST API", description = "Create Category REST API is used to save categories in database")
    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATED")
    @PostMapping
    public ResponseEntity<ResponseCategoryDto> save(@RequestBody CreateCategoryDto createCategoryDto) {
        return new ResponseEntity<>(categoryService.save(createCategoryDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Find All Categories REST API", description = "Find All Categories REST API is used to fetch all the categories from the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @GetMapping
    public ResponseEntity<List<ResponseCategoryDto>> getAll() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @Operation(
            summary = "Get Category By Id REST API",
            description = "Get Category By Id REST API is used to get a single category from the database"
    )
    @GetMapping("/{id}")
    public ResponseEntity<ResponseCategoryDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @PutMapping("/{id}")
    public ResponseEntity<ResponseCategoryDto> update(@PathVariable Long id, @RequestBody CreateCategoryDto updateCategoryDto) {
        return ResponseEntity.ok(categoryService.update(id, updateCategoryDto));
    }

    @Operation(summary = "Delete Category REST API", description = "Delete Category REST API is used to delete a particular category from the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


