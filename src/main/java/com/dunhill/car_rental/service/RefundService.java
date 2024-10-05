package com.dunhill.car_rental.service;

import com.dunhill.car_rental.Dtos.CreateRefundDto;
import com.dunhill.car_rental.Dtos.ResponseRefundDto;
import com.dunhill.car_rental.Entity.Refund;
import com.dunhill.car_rental.Exceptions.NotFoundException;
import com.dunhill.car_rental.mapper.RefundMapper;
import com.dunhill.car_rental.repository.RefundRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RefundService {

    private RefundRepository refundRepository;
    private RefundMapper refundMapper;

    // Ruajtja e një Refund-i të ri
    public ResponseRefundDto save(CreateRefundDto createRefundDto){
        Refund refund = refundMapper.mapToEntity(createRefundDto);
        Refund savedRefund = refundRepository.save(refund);
        return refundMapper.mapToDto(savedRefund);
    }

    public List<ResponseRefundDto> getAll(){
        return refundRepository.findAll().stream()
                .map(refundMapper::mapToDto)
                .toList();
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
}


