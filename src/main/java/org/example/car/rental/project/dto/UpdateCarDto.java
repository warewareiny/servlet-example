package org.example.car.rental.project.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class UpdateCarDto {

    Long id;
    String brand;
    String model;
    Integer productionYear;
    BigDecimal pricePerDay;
    String carNumber;

}
