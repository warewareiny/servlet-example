package org.example.car.rental.project.mapper;

import org.example.car.rental.project.dto.CreateCarDto;
import org.example.car.rental.project.entity.Car;

public class CreateCarMapper implements Mapper<CreateCarDto, Car> {

    private static final CreateCarMapper INSTANCE = new CreateCarMapper();

    public static CreateCarMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public Car mapFrom(CreateCarDto object) {
        return Car.builder()
                .brand(object.getBrand())
                .model(object.getModel())
                .productionYear(object.getProductionYear())
                .pricePerDay(object.getPricePerDay())
                .carNumber(object.getCarNumber())
                .build();
    }
}
