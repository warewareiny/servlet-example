package org.example.car.rental.project.exception;

import lombok.Getter;

import java.util.List;
import org.example.car.rental.project.validator.Error;

@Getter
public class ValidationException extends RuntimeException {

    private final List<Error> errors;

    public ValidationException(List<Error> errors) {
        this.errors = errors;
    }
}
