package com.dunhill.car_rental.RepositoryTest;

import com.dunhill.car_rental.entity.Category;
import com.dunhill.car_rental.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    private Category category1;
    private Category category2;
    private Category category3;

    @BeforeEach
    void setUp() {
        //global given
        category1 = Category.builder().id(1L).createdAt(LocalDateTime.now()).code("2004").username("emi").description("benz").categoryType("b class").priority(1).rating(10).build();
        category2 = Category.builder().id(2L).createdAt(LocalDateTime.now()).code("2003").username("emi").description("benz").categoryType("b class").priority(1).rating(10).build();
        category3 = Category.builder().id(3L).createdAt(LocalDateTime.now()).code("2002").username("emi").description("benz").categoryType("b class").priority(1).rating(10).build();
    }
    @Test
    public void save(){
        //action/when
        Category savedCategory = categoryRepository.save(category1);

        //then
        assertThat(savedCategory).isNotNull();
        assertThat(savedCategory.getId()).isPositive();
        assertThat(savedCategory.getId()).isEqualTo(1L);
    }

    @Test
    public void findAll(){
        //action
        Category saved1 = categoryRepository.save(category1);
        Category saved2 = categoryRepository.save(category2);
        Category saved3 = categoryRepository.save(category3);

        List<Category> categoryList = categoryRepository.findAll();

        //then
        assertThat(categoryList).isNotNull();
    }

    @Test
    public void findById(){
        //action
        Category c1 = categoryRepository.save(category1);
        Category c2 = categoryRepository.save(category2);
        Category c3 = categoryRepository.save(category3);

        Category found1 = categoryRepository.findById(1L).get();
        Category found2 = categoryRepository.findById(2L).get();
        Category found3 = categoryRepository.findById(3L).get();

        //then
        assertThat(found1).isNotNull();
        assertThat(found2).isNotNull();
        assertThat(found3).isNotNull();
        assertThat(found1.getId()).isEqualTo(1L);
        assertThat(found2.getId()).isEqualTo(2L);
        assertThat(found3.getId()).isEqualTo(3L);
    }

    @Test
    public void delete(){
        //action
        Category c1 = categoryRepository.save(category1);
        Category c2 = categoryRepository.save(category2);
        Category c3 = categoryRepository.save(category3);

        categoryRepository.delete(c3);
       Optional<Category> find = categoryRepository.findById(c3.getId());

        //then
        assertThat(find).isNotPresent();
    }

    @Test
    public void getByUsername(){
        categoryRepository.save(category1);

        List<Category> find = categoryRepository.findByUsername("emi");

        assertThat(find).isNotNull();
        assertThat(find.get(0).getUsername()).isEqualTo("emi");
    }
}
