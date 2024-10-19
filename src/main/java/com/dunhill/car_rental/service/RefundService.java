package com.dunhill.car_rental.service;

import com.dunhill.car_rental.dtos.CreateRefundDto;
import com.dunhill.car_rental.dtos.ResponseRefundDto;
import com.dunhill.car_rental.entity.Refund;
import com.dunhill.car_rental.exceptions.NotFoundException;
import com.dunhill.car_rental.mapper.RefundMapper;
import com.dunhill.car_rental.repository.RefundRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class RefundService {

    private RefundRepository refundRepository;
    private RefundMapper refundMapper;


    public ResponseRefundDto save(CreateRefundDto createRefundDto){
        Refund refund = refundMapper.mapToEntity(createRefundDto);
        Refund savedRefund = refundRepository.save(refund);
        return refundMapper.mapToDto(savedRefund);
    }

    public List<ResponseRefundDto> getAll(){
        return refundRepository.findAll().stream().map(refundMapper::mapToDto).toList();
    }

    public void delete(long id){
        Refund found = refundRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Refund not found!"));
        refundRepository.delete(found);
    }

    public ResponseRefundDto update(CreateRefundDto createRefundDto, Long id){
        Refund found = refundRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Refund not found!"));
        found = refundMapper.update(createRefundDto, found);
        return refundMapper.mapToDto(refundRepository.save(found));
    }

    public List<ResponseRefundDto> search(LocalDate dateOfReturn, BigDecimal surcharge,String comments){
        return refundRepository.findByDateOfReturnAndSurchargeAndComments(dateOfReturn,surcharge,comments)
                .stream().map(refundMapper::mapToDto).toList();

    }
}


