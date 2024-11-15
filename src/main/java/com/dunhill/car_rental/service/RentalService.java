package com.dunhill.car_rental.service;

import com.dunhill.car_rental.dtos.rentalDto.CreateRentalDto;
import com.dunhill.car_rental.dtos.rentalDto.ResponseRentalDto;
import com.dunhill.car_rental.entity.Rental;
import com.dunhill.car_rental.exceptions.NotFoundException;
import com.dunhill.car_rental.mapper.RentalMapper;
import com.dunhill.car_rental.repository.RentalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RentalService {

    private RentalRepository rentalRepository;
    private RentalMapper rentalMapper;

    public ResponseRentalDto save(CreateRentalDto createRentalDto) {
        Rental rental = rentalMapper.mapToEntity(createRentalDto);
        Rental savedRental = rentalRepository.save(rental);
        return rentalMapper.mapToDto(savedRental);
    }

    public List<ResponseRentalDto> getAll() {
        return rentalRepository.findAll().stream().map(rentalMapper::mapToDto).toList();
    }

    public void delete(Long id) {
        Rental found = rentalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Rental not found!"));
        rentalRepository.delete(found);
    }

    public ResponseRentalDto update(CreateRentalDto createRentalDto, Long id) {
        Rental found = rentalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Rental not found!"));
        found = rentalMapper.update(createRentalDto, found);
        return rentalMapper.mapToDto(rentalRepository.save(found));
    }
    public List<ResponseRentalDto> search(String name, String internetDomain, String contactAddress) {
        List<Rental> rentals = rentalRepository.findByNameAndInternetDomainAndContactAddress(name, internetDomain, contactAddress);
        return rentals.stream()
                .map(rentalMapper::mapToDto).toList();
    }

}
