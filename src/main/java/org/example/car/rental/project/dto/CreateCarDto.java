package org.example.car.rental.project.dto;

import lombok.Builder;
import lombok.Value;
import org.example.car.rental.project.entity.CarStatus;

import java.math.BigDecimal;

@Value
@Builder
public class CreateCarDto {

    String brand;
    String model;
    Integer productionYear;
    BigDecimal pricePerDay;
    String carNumber;
}
