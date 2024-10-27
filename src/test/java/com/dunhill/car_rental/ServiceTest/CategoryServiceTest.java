package com.dunhill.car_rental.ServiceTest;

import com.dunhill.car_rental.dtos.categoryDto.CreateCategoryDto;
import com.dunhill.car_rental.dtos.categoryDto.ResponseCategoryDto;
import com.dunhill.car_rental.entity.Category;
import com.dunhill.car_rental.mapper.CategoryMapper;
import com.dunhill.car_rental.repository.CategoryRepository;
import com.dunhill.car_rental.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryMapper categoryMapper;

    private ResponseCategoryDto responseCategoryDto;
    private CreateCategoryDto createCategoryDto;
    private Category category;

    @BeforeEach
    void setUp() {
        //global given
        category = Category.builder().id(1L).createdAt(LocalDateTime.now()).code("2004").username("emi").description("benz").categoryType("b class").priority(1).rating(10).build();
        createCategoryDto= CreateCategoryDto.builder().createdAt(LocalDateTime.now()).name("emi").description("benz").categoryType("b class").priority(1).rating(10).build();
        responseCategoryDto = ResponseCategoryDto.builder().id(1L).createdAt(LocalDateTime.now()).name("emi").description("benz").categoryType("b class").priority(1).rating(10).build();
    }

    @Test
    public void save(){
        //action
        when(categoryMapper.mapToEntity(any(CreateCategoryDto.class))).thenReturn(category);
        when(categoryRepository.save(any(Category.class))).thenReturn(category);
        when(categoryMapper.mapToDto(any(Category.class))).thenReturn(responseCategoryDto);

        categoryService.save(createCategoryDto);

        //then
        verify(categoryRepository).save(category);

    }

    @Test
    public void getAll() {

        //given
        List<Category> categories = asList(new Category());
        when(categoryRepository.findAll()).thenReturn(categories);

        when(categoryMapper.mapToDto(any(Category.class))).thenReturn(responseCategoryDto);

        //when
        List<ResponseCategoryDto> find = categoryService.findAll();

        //then
        assertEquals(responseCategoryDto, find.get(0));
        verify(categoryRepository).findAll();
        verify(categoryMapper).mapToDto(any(Category.class));
    }

    @Test
    public void getById() {
        //given
        Long id = 1L;
        Optional<Category> optionalCategory = Optional.of(category);

        when(categoryRepository.findById(id)).thenReturn(optionalCategory);
        when(categoryMapper.mapToDto(any(Category.class))).thenReturn(responseCategoryDto);

        //when
        ResponseCategoryDto find = categoryService.findById(id);

        //then
        assertEquals(responseCategoryDto, find);
        verify(categoryRepository).findById(id);
        verify(categoryMapper).mapToDto(any(Category.class));
    }

    @Test
    public void deleteById() {
        //given
        Long id = 1L;
        Optional<Category> optionalCategory = Optional.of(category);

        when(categoryRepository.findById(id)).thenReturn(optionalCategory);

        //when
        categoryService.delete(id);

        //then
        verify(categoryRepository).findById(id);
        verify(categoryRepository).delete(category);
    }

    @Test
    public void update() {
        //given
        Long id = 1L;
        Optional<Category> optionalCategory = Optional.of(category);

        when(categoryRepository.findById(id)).thenReturn(optionalCategory);
        when(categoryRepository.save(any(Category.class))).thenReturn(category);
        when(categoryMapper.mapToDto(category)).thenReturn(responseCategoryDto);

        //when
        ResponseCategoryDto updatedDto = categoryService.update(id, createCategoryDto);

        //then
        assertEquals(id, updatedDto.getId());
        assertNotNull(updatedDto.getCreatedAt());
        verify(categoryRepository).findById(id);
        verify(categoryRepository).save(any(Category.class));
        verify(categoryMapper).mapToDto(category);
    }





}
