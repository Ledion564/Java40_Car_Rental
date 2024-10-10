package com.dunhill.car_rental.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseRentalDto {
    private Long id;
    private String name;
    private String internetDomain;
    private String contactAddress;
    private String owner;
    private String logotype;
}
