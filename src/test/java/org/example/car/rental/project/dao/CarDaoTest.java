package org.example.car.rental.project.dao;

import org.example.car.rental.project.CarIntegrationTestBase;
import org.example.car.rental.project.entity.Car;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
    void shouldSaveCar() {
//        todo
    }

    @Test
    @Tag("findById")
    void shouldFindByIdExistingCar() {
//        todo
    }

    @Test
    @Tag("findById")
    void shouldReturnEmptyOptionalIfFindByIdIncorrectCar() {
//        todo
    }

    @Test
    @Tag("findById")
    void shouldUpdateStatus() {
//        todo
    }

    @Test
    @Tag("findById")
    void shouldReturnTrueIfUpdateExistingCar() {
//        todo
    }

    @Test
    @Tag("findById")
    void shouldDoNothingIfUpdateNotExistingCar() {
//        todo
    }
}
