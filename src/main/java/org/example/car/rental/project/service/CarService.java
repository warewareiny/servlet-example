package org.example.car.rental.project.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.car.rental.project.dao.CarDao;
import org.example.car.rental.project.dto.CarDto;
import org.example.car.rental.project.dto.CreateCarDto;
import org.example.car.rental.project.entity.Car;
import org.example.car.rental.project.exception.ValidationException;
import org.example.car.rental.project.mapper.CreateCarMapper;
import org.example.car.rental.project.validator.CreateCarValidator;
import org.example.car.rental.project.validator.ValidationResult;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarService {

    private static final CarService INSTANCE = new CarService();

    private final CarDao carDao = CarDao.getInstance();
    private final CreateCarValidator createCarValidator = CreateCarValidator.getInstance();
    private final CreateCarMapper createCarMapper = CreateCarMapper.getInstance();

    public static CarService getInstance() {
        return INSTANCE;
    }

    public Optional<CarDto> findById(Long id) {
        return carDao.findById(id)
                .map(car -> CarDto.builder()
                        .id(car.getId())
                        .brand(car.getBrand())
                        .model(car.getModel())
                        .carNumber(car.getCarNumber())
                        .productionYear(car.getProductionYear())
                        .pricePerDay(car.getPricePerDay())
                        .status(car.getStatus())
                        .build());
    }

    public Long create(CreateCarDto createCarDto) {
        ValidationResult validationResult = createCarValidator.isValid(createCarDto);

        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }

        Car carEntity = createCarMapper.mapFrom(createCarDto);
        carDao.save(carEntity);

        return carEntity.getId();
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
