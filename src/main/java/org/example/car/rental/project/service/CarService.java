package org.example.car.rental.project.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.car.rental.project.dao.CarDao;
import org.example.car.rental.project.dto.CarDto;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarService {

    private static final CarService INSTANCE = new CarService();

    private final CarDao carDao = CarDao.getInstance();

    public static CarService getInstance() {
        return INSTANCE;
    }

    public List<CarDto> findAll() {
        return carDao.findAll().stream()
                .map(car -> CarDto.builder()
                        .id(car.getId())
                        .brand(car.getBrand())
                        .model(car.getModel())
                        .carNumber(car.getCarNumber())
                        .productionYear(car.getProductionYear())
                        .pricePerDay(car.getPricePerDay())
                        .status(car.getStatus())
                        .build()
                )
                .collect(Collectors.toList());
    }
}
