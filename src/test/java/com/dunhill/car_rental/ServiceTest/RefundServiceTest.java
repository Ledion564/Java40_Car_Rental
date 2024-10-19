package com.dunhill.car_rental.ServiceTest;

import com.dunhill.car_rental.dtos.CreateRefundDto;
import com.dunhill.car_rental.dtos.ResponseRefundDto;
import com.dunhill.car_rental.entity.Refund;
import com.dunhill.car_rental.mapper.RefundMapper;
import com.dunhill.car_rental.repository.RefundRepository;
import com.dunhill.car_rental.service.RefundService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RefundServiceTest {

    @Mock
    private RefundRepository refundRepository;

    @Mock
    private RefundMapper refundMapper;

    @InjectMocks
    private RefundService refundService;

    private ResponseRefundDto responseRefundDto;
    private CreateRefundDto createRefundDto;
    private Refund refund;



    @BeforeEach
    void setUp() {
        refund=Refund.builder().dateOfReturn(LocalDate.now()).comments("Refund").surcharge(new BigDecimal("10.50")).build();
        responseRefundDto=ResponseRefundDto.builder().dateOfReturn(LocalDate.now()).comments("Refund").surcharge(new BigDecimal("10.50")).build();
        createRefundDto=CreateRefundDto.builder().dateOfReturn(LocalDate.now()).comments("Refund").surcharge(new BigDecimal("10.50")).build();
    }

    @Test
    void save() {
        when(refundMapper.mapToEntity(any(CreateRefundDto.class))).thenReturn(refund);
        when(refundRepository.save(any(Refund.class))).thenReturn(refund);
        when(refundMapper.mapToDto(any(Refund.class))).thenReturn(responseRefundDto);

        refundService.save(createRefundDto);

        verify(refundRepository).save(refund);

    }

    @Test
    void getAll() {
        List<Refund> refund= Arrays.asList(new Refund());
        when(refundRepository.findAll()).thenReturn(refund);
        when(refundMapper.mapToDto(any(Refund.class))).thenReturn(responseRefundDto);
        refundService.getAll();

        verify(refundRepository).findAll();
        verify(refundMapper).mapToDto(any(Refund.class));
    }

    @Test
    void delete() {
        when(refundRepository.findById(refund.getId())).thenReturn(Optional.of(refund));
        refundService.delete(refund.getId());
        verify(refundRepository).delete(refund);
    }

    @Test
    void update() {
        when(refundRepository.findById(refund.getId())).thenReturn(Optional.of(refund));
        when(refundMapper.mapToDto(any(Refund.class))).thenReturn(responseRefundDto);
        refundService.update(createRefundDto,refund.getId());
        verify(refundRepository).findById(refund.getId());
        verify(refundMapper).mapToDto(any(Refund.class));
    }

    @Test
    void search(){
        List<Refund> refund = Arrays.asList(new Refund());
        Refund refundEntity = refund.get(0);
        when(refundRepository.findByDateOfReturnAndSurchargeAndComments(refundEntity.getDateOfReturn(), refundEntity.getSurcharge(), refundEntity.getComments()))
        .thenReturn(refund);
        when(refundMapper.mapToDto(any(Refund.class))).thenReturn(responseRefundDto);
        refundService.search(refundEntity.getDateOfReturn(), refundEntity.getSurcharge(), refundEntity.getComments());
        verify(refundRepository).findByDateOfReturnAndSurchargeAndComments(refundEntity.getDateOfReturn(), refundEntity.getSurcharge(), refundEntity.getComments());
        verify(refundMapper).mapToDto(any(Refund.class));
    }
}