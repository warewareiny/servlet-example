package org.example.car.rental.project.mapper;

public interface Mapper<F, T> {

    T mapFrom(F object);
}