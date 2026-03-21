package org.example.car.rental.project.dao;

import org.example.car.rental.project.CarIntegrationTestBase;
import org.example.car.rental.project.entity.Car;
import org.example.car.rental.project.entity.CarStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.example.car.rental.project.testdata.CarTestData.VALID_CAR;

public class CarDaoTest extends CarIntegrationTestBase {

    private final CarDao carDao = CarDao.getInstance();

    @Test
    @Tag("delete")
    void shouldReturnTrueIfDeleteExistingCar() {
        assertThat(carDao.delete(1L)).isTrue();
    }

    @Test
    @Tag("delete")
    void shouldReturnFalseIfDeleteCarWithIncorrectId() {
        assertThat(carDao.delete(666L)).isFalse();
    }

    @Test
    @Tag("findAll")
    void shouldReturnAllCars() {
        List<Car> allCars = carDao.findAll();

        assertThat(allCars).isNotNull()
                .hasSize(3)
                .extracting(Car::getBrand)
                .containsExactly("Toyota", "BMW", "Audi");
    }

    @Test
    @Tag("save")
    void shouldSaveValidCar() {
        Car savedCar = carDao.save(VALID_CAR);
        assertThat(savedCar).isNotNull();
        assertThat(savedCar).extracting(Car::getBrand, Car::getProductionYear, Car::getModel)
                .containsExactly(VALID_CAR.getBrand(), VALID_CAR.getProductionYear(), VALID_CAR.getModel());
    }

    @Test
    @Tag("findById")
    void shouldFindByIdExistingCar() {
        Optional<Car> car = carDao.findById(3L);
        assertThat(car).isNotNull().get().extracting(Car::getBrand, Car::getProductionYear, Car::getModel)
                .containsExactly("Audi", 2019, "A6");
    }

    @Test
    @Tag("findById")
    void shouldReturnEmptyOptionalIfFindByIdIncorrectCar() {
        Optional<Car> car = carDao.findById(30000L);
        assertThat(car).isEmpty();
    }

    @Test
    @Tag("updateStatus")
    void shouldUpdateStatus() {
        carDao.updateStatus(3L, CarStatus.AVAILABLE);
        assertThat(carDao.findById(3L)).isPresent()
                .get()
                .extracting(Car::getStatus)
                .isEqualTo(CarStatus.AVAILABLE);
    }

    @Test
    @Tag("update")
    void ,() {
        Car savedCar = carDao.save(VALID_CAR);

        savedCar.setBrand("BMW");
        savedCar.setModel("X5");

        assertThat(carDao.update(savedCar)).isTrue();
    }
}
