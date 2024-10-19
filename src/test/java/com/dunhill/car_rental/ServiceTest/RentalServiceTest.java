package com.dunhill.car_rental.ServiceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.dunhill.car_rental.dtos.CreateRentalDto;
import com.dunhill.car_rental.dtos.ResponseRentalDto;
import com.dunhill.car_rental.entity.Rental;
import com.dunhill.car_rental.mapper.RentalMapper;
import com.dunhill.car_rental.repository.RentalRepository;
import com.dunhill.car_rental.service.RentalService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RentalServiceTest {

    @Mock
    private RentalRepository rentalRepository;

    @Mock
    private RentalMapper rentalMapper;

    @InjectMocks
    private RentalService rentalService;

    private ResponseRentalDto responseRentalDto;
    private CreateRentalDto createRentalDto;
    private Rental rental;

    @BeforeEach
    void setUp() {
        rental = Rental.builder().id(1L).name("Test Rental").internetDomain("test.com").contactAddress("123 Test St.").owner("Test Owner").logotype("test_logo.png").build();
        responseRentalDto = ResponseRentalDto.builder().id(1L).name("Test Rental").internetDomain("test.com").contactAddress("123 Test St.").owner("Test Owner").logotype("test_logo.png").build();
        createRentalDto = CreateRentalDto.builder().name("Test Rental").internetDomain("test.com").contactAddress("123 Test St.").owner("Test Owner").logotype("test_logo.png").build();
    }

    @Test
    void save() {
        when(rentalMapper.mapToEntity(any(CreateRentalDto.class))).thenReturn(rental);
        when(rentalRepository.save(any(Rental.class))).thenReturn(rental);
        when(rentalMapper.mapToDto(any(Rental.class))).thenReturn(responseRentalDto);

        rentalService.save(createRentalDto);

        verify(rentalRepository).save(rental);
    }

    @Test
    void getAll() {
        List<Rental> rentals = Arrays.asList(rental);
        when(rentalRepository.findAll()).thenReturn(rentals);
        when(rentalMapper.mapToDto(any(Rental.class))).thenReturn(responseRentalDto);

        rentalService.getAll();

        verify(rentalRepository).findAll();
        verify(rentalMapper).mapToDto(any(Rental.class));
    }

    @Test
    void delete() {
        when(rentalRepository.findById(rental.getId())).thenReturn(Optional.of(rental));
        rentalService.delete(rental.getId());
        verify(rentalRepository).delete(rental);
    }

    @Test
    void update() {
        when(rentalRepository.findById(rental.getId())).thenReturn(Optional.of(rental));
        when(rentalMapper.mapToDto(any(Rental.class))).thenReturn(responseRentalDto);

        rentalService.update(createRentalDto, rental.getId());

        verify(rentalRepository).findById(rental.getId());
        verify(rentalMapper).mapToDto(any(Rental.class));
    }


    @Test
    void search() {
        List<Rental> rentals = Arrays.asList(rental);
        when(rentalRepository.findByNameAndInternetDomainAndContactAddress(rental.getName(), rental.getInternetDomain(), rental.getContactAddress()))
                .thenReturn(rentals);
        when(rentalMapper.mapToDto(any(Rental.class))).thenReturn(responseRentalDto);

        rentalService.search(rental.getName(), rental.getInternetDomain(), rental.getContactAddress());

        verify(rentalRepository).findByNameAndInternetDomainAndContactAddress(rental.getName(), rental.getInternetDomain(), rental.getContactAddress());
        verify(rentalMapper).mapToDto(any(Rental.class));
    }
}
