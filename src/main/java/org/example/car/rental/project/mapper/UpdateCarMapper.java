package org.example.car.rental.project.mapper;

import org.example.car.rental.project.dto.UpdateCarDto;
import org.example.car.rental.project.entity.Car;

import java.math.BigDecimal;

public class UpdateCarMapper implements Mapper<UpdateCarDto, Car> {

    private static final UpdateCarMapper INSTANCE = new UpdateCarMapper();

    public static UpdateCarMapper getInstance() {
        return INSTANCE;
    }

    private UpdateCarMapper() {}

    @Override
    public Car mapFrom(UpdateCarDto object) {
        return Car.builder()
                .id(object.getId())
                .brand(object.getBrand())
                .pricePerDay(BigDecimal.valueOf(Integer.parseInt(object.getPricePerDay())))
                .model(object.getModel())
                .carNumber(object.getCarNumber())
                .productionYear(Integer.valueOf(object.getProductionYear()))
                .build();
    }
}
