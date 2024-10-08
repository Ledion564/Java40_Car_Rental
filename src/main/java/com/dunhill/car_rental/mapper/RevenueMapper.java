package com.dunhill.car_rental.mapper;

import com.dunhill.car_rental.Dtos.CreateRevenueDto;
import com.dunhill.car_rental.Dtos.ResponseRevenueDto;
import com.dunhill.car_rental.Entity.Revenue;
import org.springframework.stereotype.Component;

@Component
public class RevenueMapper {
    public Revenue mapToEntity(CreateRevenueDto createRevenueDto) {
        Revenue revenue = new Revenue();
        revenue.setTotalAmount(createRevenueDto.getTotalAmount());
        revenue.setApprovedAmount(createRevenueDto.getApprovedAmount());
        revenue.setUnapprovedAmount(createRevenueDto.getUnapprovedAmount());

        return revenue;
    }

    public ResponseRevenueDto mapToDto(Revenue revenue) {
        ResponseRevenueDto responseRevenueDto = new ResponseRevenueDto();
        responseRevenueDto.setTotalAmount(revenue.getTotalAmount());
        responseRevenueDto.setApprovedAmount(revenue.getApprovedAmount());
        responseRevenueDto.setUnapprovedAmount(revenue.getUnapprovedAmount());

        return responseRevenueDto;
    }

    public Revenue update(CreateRevenueDto dto, Revenue revenue) {
        revenue.setTotalAmount(dto.getTotalAmount());
        revenue.setApprovedAmount(dto.getApprovedAmount());
        revenue.setUnapprovedAmount(dto.getUnapprovedAmount());

        return revenue;
    }
}
