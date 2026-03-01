package org.example.car.rental.project.validator;

public interface Validator<T> {

    ValidationResult isValid(T object);
}
