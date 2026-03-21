package org.example.car.rental.project.dao;

import org.example.car.rental.project.CarIntegrationTestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
//        todo
    }

    @Test
    @Tag("findAll")
    void shouldReturnAllCars() {
//        todo
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
