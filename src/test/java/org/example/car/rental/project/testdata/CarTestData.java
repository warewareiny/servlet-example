package org.example.car.rental.project.testdata;

import org.example.car.rental.project.entity.Car;

import java.math.BigDecimal;

public class CarTestData {

    public static final Car VALID_CAR = Car.builder()
            .id(6L)
            .brand("test")
            .model("test model")
            .productionYear(2000)
            .pricePerDay(BigDecimal.ZERO)
            .carNumber("123456")
            .build();

    public static final Car INVALID_CAR = Car.builder()
            .id(6000L)
            .brand("")
            .model("")
            .productionYear(0)
            .pricePerDay(BigDecimal.ZERO)
            .carNumber("")
            .build();
}
