package org.example.car.rental.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

    private Long id;
    private String brand;
    private String model;
    private Integer productionYear;
    private BigDecimal pricePerDay;
    private String carNumber;
    private CarStatus status;

}
