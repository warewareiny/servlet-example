package org.example.car.rental.project.mapper;

import org.example.car.rental.project.dto.UpdateCarDto;
import org.example.car.rental.project.entity.Car;

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
                .pricePerDay(object.getPricePerDay())
                .model(object.getModel())
                .carNumber(object.getCarNumber())
                .productionYear(object.getProductionYear())
                .build();
    }
}
