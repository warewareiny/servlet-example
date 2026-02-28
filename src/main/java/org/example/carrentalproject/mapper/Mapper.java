package org.example.carrentalproject.mapper;

public interface Mapper<F, T> {

    T mapFrom(F object);
}