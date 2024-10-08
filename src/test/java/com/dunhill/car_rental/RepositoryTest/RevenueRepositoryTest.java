package com.dunhill.car_rental.RepositoryTest;

import com.dunhill.car_rental.Entity.Revenue;
import com.dunhill.car_rental.repository.RevenueRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@DataJpaTest
public class RevenueRepositoryTest {

    @Autowired
    private RevenueRepository revenueRepository;

    private Revenue revenue;

    @BeforeEach
    void setUp() {
         revenue = Revenue.builder().totalAmount(200.2).approvedAmount(222.3).unapprovedAmount(100.1).build();
    }




    @Test
    public void testFindByTotalAmount() {
        //given
        revenueRepository.save(revenue);

        //when
       List<Revenue> revenueList = revenueRepository.findByTotalAmount(200.2);

       //then
        assertThat(revenueList).isNotNull();
        assertThat(revenueList).isNotEmpty();
        assertThat(revenueList.get(0).getTotalAmount()).isEqualTo(200.2);

    }

    @Test
    public void testFindByTotalAmountWithIndex(){
        //given
        revenueRepository.save(revenue);

        //when
        List<Revenue> revenueList = revenueRepository.findByTotalAmountWithIndex(200.2);

        //then
        assertThat(revenueList).isNotNull();
        assertThat(revenueList).isNotEmpty();
        assertThat(revenueList.get(0).getTotalAmount()).isEqualTo(200.2);
    }

    @Test
    public void findByTotalAmountNative(){
        revenueRepository.save(revenue);

        List<Revenue> revenueList = revenueRepository.findByTotalAmountNative(200.2);

        assertThat(revenueList).isNotNull();
        assertThat(revenueList).isNotEmpty();
        assertThat(revenueList.get(0).getTotalAmount()).isEqualTo(200.2);
    }

    @Test
    public void findByTotalAmountNativeWithIndex(){
        revenueRepository.save(revenue);

        List<Revenue> revenueList = revenueRepository.findByTotalAmountNativeWithIndex(200.2);

        assertThat(revenueList).isNotNull();
        assertThat(revenueList).isNotEmpty();
        assertThat(revenueList.get(0).getTotalAmount()).isEqualTo(200.2);
    }



}
