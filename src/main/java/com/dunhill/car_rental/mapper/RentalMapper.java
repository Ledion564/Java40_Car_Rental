package com.dunhill.car_rental.mapper;

import com.dunhill.car_rental.dtos.CreateRentalDto;
import com.dunhill.car_rental.dtos.ResponseRentalDto;
import com.dunhill.car_rental.entity.Rental;
import org.springframework.stereotype.Component;

@Component
public class RentalMapper {

    public Rental mapToEntity(CreateRentalDto createRentalDto) {
        Rental rental = new Rental();
        rental.setName(createRentalDto.getName());
        rental.setInternetDomain(createRentalDto.getInternetDomain());
        rental.setContactAddress(createRentalDto.getContactAddress());
        rental.setOwner(createRentalDto.getOwner());
        rental.setLogotype(createRentalDto.getLogotype());
        return rental;
    }

    public ResponseRentalDto mapToDto(Rental rental) {
        ResponseRentalDto responseRentalDto = new ResponseRentalDto();
        responseRentalDto.setId(rental.getId());
        responseRentalDto.setName(rental.getName());
        responseRentalDto.setInternetDomain(rental.getInternetDomain());
        responseRentalDto.setContactAddress(rental.getContactAddress());
        responseRentalDto.setOwner(rental.getOwner());
        responseRentalDto.setLogotype(rental.getLogotype());
        return responseRentalDto;
    }

    public Rental update(CreateRentalDto createRentalDto, Rental rental) {
        rental.setName(createRentalDto.getName());
        rental.setInternetDomain(createRentalDto.getInternetDomain());
        rental.setContactAddress(createRentalDto.getContactAddress());
        rental.setOwner(createRentalDto.getOwner());
        rental.setLogotype(createRentalDto.getLogotype());
        return rental;
    }
}