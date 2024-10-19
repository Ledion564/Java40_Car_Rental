package com.dunhill.car_rental.service;

import com.dunhill.car_rental.dtos.CreateReservationDto;
import com.dunhill.car_rental.dtos.ResponseReservationDto;
import com.dunhill.car_rental.entity.Reservation;
import com.dunhill.car_rental.exceptions.NotFoundException;
import com.dunhill.car_rental.mapper.ReservationMapper;
import com.dunhill.car_rental.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ReservationService {
    private ReservationRepository reservationRepository;
    private ReservationMapper reservationMapper;

    public ResponseReservationDto save(CreateReservationDto createReservationDto){
        Reservation reservation= reservationMapper.mapToEntity(createReservationDto);
        Reservation savedReservation= reservationRepository.save(reservation);
        ResponseReservationDto responseReservationDto = reservationMapper.mapToDto(savedReservation);
        return responseReservationDto;
    }

    public List<ResponseReservationDto > getAll(){
        return reservationRepository.findAll().stream().map(reservationMapper::mapToDto).toList();
    }
    public void delete(long id){
        Reservation found= reservationRepository.findById(id).
                orElseThrow(()-> new NotFoundException("Cannot find this reservation!"));
        reservationRepository.delete(found);
    }
    public ResponseReservationDto update(Long id, CreateReservationDto dto){
        Reservation reservation= reservationRepository.findById(id).orElseThrow(()->new RuntimeException("Reservation not found"));
        reservation.setDateOfBooking(dto.getDateOfBooking());
        reservation.setDateFrom(dto.getDateFrom());
        reservation.setDateTo(dto.getDateTo());
        reservation.setAmount(dto.getAmount());
        return reservationMapper.mapToDto(reservation);
    }
}
