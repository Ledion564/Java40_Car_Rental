package com.dunhill.car_rental.dtos.securityDto;

import com.dunhill.car_rental.entity.enums.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data transfer object for creating a new order")
public class CreateOrderDto {

    @Schema(description = "First name of the customer", example = "John", required = true)
    private String firstName;

    @Schema(description = "Last name of the customer", example = "Doe", required = true)
    private String lastName;

    @Schema(description = "Phone number of the customer", example = "+123456789", required = true)
    private String phone;

    @Schema(description = "Address of the customer", example = "123 Main St, Tirana, Albania", required = true)
    private String address;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Status of the order", example = "PROCESSING", required = true)
    private OrderStatus orderStatus;

    @Schema(description = "List of cars included in the order", required = true)
    private List<OrderCarDto> orderCars;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "Data transfer object for car in an order")
    public static class OrderCarDto {
        @Schema(description = "ID of the car", example = "5", required = true)
        private Long carId;

        @Schema(description = "Quantity of the car", example = "2", required = true)
        private int quantity;
    }
}
