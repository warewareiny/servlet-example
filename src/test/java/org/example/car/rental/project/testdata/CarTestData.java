package org.example.car.rental.project.testdata;

import org.example.car.rental.project.entity.Car;
import org.example.car.rental.project.entity.CarStatus;

import java.math.BigDecimal;

public class CarTestData {

    public static final Car VALID_CAR = Car.builder()
            .id(4L)
            .brand("test")
            .model("test model")
            .productionYear(2000)
            .pricePerDay(BigDecimal.ZERO)
            .carNumber("123456")
            .status(CarStatus.AVAILABLE)
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
