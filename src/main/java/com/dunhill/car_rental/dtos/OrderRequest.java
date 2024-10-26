package com.dunhill.car_rental.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class OrderRequest {

    @Schema(implementation = Map.class, example = "{\"4\":3, \"5\":3}")
    @NotEmpty
    private Map<Long, Integer> cars;

    @Schema(example = "Mario Rossi")
    @NotNull
    @Size(min = 1, max = 100)
    private String customerName;

    @Schema(example = "Via Roma 1, 00100 Roma RM, Italy")
    @NotNull
    @Size(min = 1, max = 500)
    private String customerAddress;

    @Schema(example = "+393331234567")
    @NotNull
    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Phone number must be a valid international format")
    private String customerPhone;
}
