package org.example.car.rental.project.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.example.car.rental.project.dao.CarDao;
import org.example.car.rental.project.dto.CarDto;
import org.example.car.rental.project.dto.CreateCarDto;
import org.example.car.rental.project.dto.UpdateCarDto;
import org.example.car.rental.project.entity.Car;
import org.example.car.rental.project.entity.CarStatus;
import org.example.car.rental.project.exception.ValidationException;
import org.example.car.rental.project.mapper.CreateCarMapper;
import org.example.car.rental.project.mapper.UpdateCarMapper;
import org.example.car.rental.project.validator.CreateCarValidator;
import org.example.car.rental.project.validator.UpdateCarValidator;
import org.example.car.rental.project.validator.ValidationResult;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarService {

    private static final CarService INSTANCE = new CarService();

    private final CarDao carDao = CarDao.getInstance();
    private final CreateCarValidator createCarValidator = CreateCarValidator.getInstance();
    private final UpdateCarValidator updateCarValidator = UpdateCarValidator.getInstance();
    private final CreateCarMapper createCarMapper = CreateCarMapper.getInstance();
    private final UpdateCarMapper updateCarMapper = UpdateCarMapper.getInstance();

    public static CarService getInstance() {
        return INSTANCE;
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

    public String updateCar(UpdateCarDto updateCarDto) {
        ValidationResult validationResult = updateCarValidator.isValid(updateCarDto);

        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }

        Car carEntity = updateCarMapper.mapFrom(updateCarDto);
        boolean updated = carDao.update(carEntity);
        return updated ? "SUCCESS" : "FAIL";
    }

    public String deleteCar(Long carId) {
        boolean deleted = carDao.delete(carId);
        return deleted ? "SUCCESS" : "FAIL";
    }

    public String bookCar(Long carId) {
        Optional<Car> carOptional = carDao.findById(carId);

        if (carOptional.isEmpty())
            return "Car not found";

        Car car = carOptional.get();

        if (car.getStatus() == CarStatus.RENTED)
            return "Car is already rented";

        if (car.getStatus() == CarStatus.BROKEN)
            return "Car is broken";

        carDao.updateStatus(carId, CarStatus.RENTED);
        return "SUCCESS";
    }

    public String unbookCar(Long carId) {
        Optional<Car> carOptional = carDao.findById(carId);

        if (carOptional.isEmpty())
            return "Car not found";

        Car car = carOptional.get();

        if (car.getStatus() != CarStatus.RENTED)
            return "Car is not rented";

        carDao.updateStatus(carId, CarStatus.AVAILABLE);
        return "SUCCESS";
    }

    public String brokeCar(Long carId) {
        Optional<Car> carOptional = carDao.findById(carId);

        if (carOptional.isEmpty())
            return "Car not found";

        Car car = carOptional.get();

        if (car.getStatus() == CarStatus.BROKEN)
            return "Car is already broken";

        carDao.updateStatus(carId, CarStatus.BROKEN);
        return "SUCCESS";
    }

    public String fixCar(Long carId) {
        Optional<Car> carOptional = carDao.findById(carId);

        if (carOptional.isEmpty())
            return "Car not found";

        Car car = carOptional.get();

        if (car.getStatus().name().equals("BROKEN")) {
            carDao.updateStatus(carId, CarStatus.AVAILABLE);
        }

        return "SUCCESS";
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
