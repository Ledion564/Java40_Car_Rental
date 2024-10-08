package com.dunhill.car_rental.service;

import com.dunhill.car_rental.Dtos.CreateRevenueDto;
import com.dunhill.car_rental.Dtos.ResponseRevenueDto;
import com.dunhill.car_rental.Entity.Revenue;
import com.dunhill.car_rental.mapper.RevenueMapper;
import com.dunhill.car_rental.repository.RevenueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RevenueService {

    private RevenueRepository revenueRepository;
    private RevenueMapper revenueMapper;

    public ResponseRevenueDto save(CreateRevenueDto createRevenueDto){
        Revenue revenue = revenueMapper.mapToEntity(createRevenueDto);
        Revenue savedRevenue = revenueRepository.save(revenue);
        ResponseRevenueDto responseRevenueDto = revenueMapper.mapToDto(savedRevenue);

        return responseRevenueDto;
    }

    public List<ResponseRevenueDto> getAll(){
        return revenueRepository.findAll().stream().map(revenueMapper::mapToDto).toList();
    }




}
