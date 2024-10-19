package com.dunhill.car_rental.RepositoryTest;

import com.dunhill.car_rental.entity.Refund;
import com.dunhill.car_rental.repository.RefundRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class RefundRepositoryTest {

    @Autowired
    private RefundRepository refundRepository;
    private Refund refund;

    @BeforeEach
    void setUp() {
        refund=Refund.builder().id(1L).dateOfReturn(LocalDate.now()).comments("Refund").surcharge(new BigDecimal("10.50")).build();
    }

    @Test
    public void testGetAll() {
        refundRepository.save(refund);
        List<Refund> refund = refundRepository.findAll();
        assertThat(refund).isNotNull();
    }

    @Test
    void testSaveRefund() {
        refundRepository.save(refund);
        assertThat(refund.getId()).isNotNull();
    }

    @Test
    void testDeleteRefund() {
        refundRepository.save(refund);
        refundRepository.deleteById(refund.getId());
        assertThat(refundRepository.findById(refund.getId())).isNull();

    }

    @Test
    void testUpdateRefund() {
        refundRepository.save(refund);
        refund.setId(refund.getId());
        refund.setDateOfReturn(LocalDate.now());
        refund.setComments("Refund");
        refundRepository.save(refund);
        assertThat(refundRepository.findById(refund.getId())).isNotNull();
    }

    @Test
    void testFindByCommentsAndSurcharge(){
        refundRepository.save(refund);
        List<Refund> refundList = refundRepository.findByCommentsAndSurcharge("Refund",new BigDecimal("10.50"));
        assertThat(refundList).isNotNull();

    }

    @Test
    void testfindByCommentsAndSurchargeWithIndex(){
        refundRepository.save(refund);
        List<Refund>refundList = refundRepository.findByCommentsAndSurcharge("Refund",new BigDecimal("10.50"));
        assertThat(refundList).isNotNull();
    }

}