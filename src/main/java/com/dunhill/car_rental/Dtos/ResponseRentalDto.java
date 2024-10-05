package com.dunhill.car_rental.Dtos;

import lombok.Data;

@Data
public class ResponseRentalDto {
    private Long id;
    private String name;
    private String internetDomain;
    private String contactAddress;
    private String owner;
    private String logotype;
}
