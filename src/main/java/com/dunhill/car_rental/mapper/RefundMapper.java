package com.dunhill.car_rental.mapper;

import com.dunhill.car_rental.Dtos.CreateRefundDto;
import com.dunhill.car_rental.Dtos.ResponseRefundDto;
import com.dunhill.car_rental.Entity.Refund;
import org.springframework.stereotype.Component;

@Component
public class RefundMapper {

    public Refund mapToEntity(CreateRefundDto createRefundDto) {
        Refund refund = new Refund();
        refund.setDateOfReturn(createRefundDto.getDateOfReturn());
        refund.setSurcharge(createRefundDto.getSurcharge());
        refund.setComments(createRefundDto.getComments());
        return refund;
    }

    public ResponseRefundDto mapToDto(Refund refund) {
        ResponseRefundDto responseRefundDto = new ResponseRefundDto();
        responseRefundDto.setId(refund.getId());
        responseRefundDto.setDateOfReturn(refund.getDateOfReturn());
        responseRefundDto.setSurcharge(refund.getSurcharge());
        responseRefundDto.setComments(refund.getComments());
        return responseRefundDto;
    }

    public Refund update(CreateRefundDto createRefundDto, Refund refund) {
        refund.setDateOfReturn(createRefundDto.getDateOfReturn());
        refund.setSurcharge(createRefundDto.getSurcharge());
        refund.setComments(createRefundDto.getComments());
        return refund;
    }
}
