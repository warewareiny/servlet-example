package org.example.car.rental.project.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UpdateCarDto {

    Long id;
    String brand;
    String model;
    String productionYear;
    String pricePerDay;
    String carNumber;

}
