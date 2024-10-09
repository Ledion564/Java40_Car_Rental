package com.dunhill.car_rental.mapper;

import com.dunhill.car_rental.Dtos.CreateReservationDto;
import com.dunhill.car_rental.Dtos.ResponseReservationDto;
import com.dunhill.car_rental.Entity.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    public Reservation mapToEntity(CreateReservationDto createReservationDto){
        Reservation reservation=new Reservation();
        reservation.setDateOfBooking(createReservationDto.getDateOfBooking());
        reservation.setDateFrom(createReservationDto.getDateFrom());
        reservation.setDateTo(createReservationDto.getDateTo());
        reservation.setAmount(createReservationDto.getAmount());
        return reservation;
    }
    public ResponseReservationDto mapToDto(Reservation reservation){
        ResponseReservationDto responseReservationDto = new ResponseReservationDto();
        responseReservationDto.setId(reservation.getId());
        responseReservationDto.setDateOfBooking(reservation.getDateOfBooking());
        responseReservationDto.setDateFrom(reservation.getDateFrom());
        responseReservationDto.setDateTo(reservation.getDateTo());
        responseReservationDto.setAmount(reservation.getAmount());
        return responseReservationDto;
    }
}
