package org.example.car.rental.project.validator;

import org.example.car.rental.project.dto.CreateCarDto;

import java.math.BigDecimal;

public class CreateCarValidator implements Validator<CreateCarDto> {

    private static final CreateCarValidator INSTANCE = new CreateCarValidator();

    public static CreateCarValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public ValidationResult isValid(CreateCarDto object) {
        ValidationResult validationResult = new ValidationResult();

        if (object.getBrand() == null || object.getBrand().isEmpty()) {
            validationResult.add(Error.of("invalid.brand", "Brand is invalid"));
        }

        if (object.getModel() == null || object.getModel().isEmpty()) {
            validationResult.add(Error.of("invalid.model", "Model is invalid"));
        }

        if (object.getProductionYear() == null || object.getProductionYear() < 1900
            || object.getProductionYear() > 2026) {
            validationResult.add(Error.of("invalid.production.year", "Production year is invalid"));
        }

        if (object.getPricePerDay() == null || object.getPricePerDay().compareTo(BigDecimal.ZERO) < 0) {
            validationResult.add(Error.of("invalid.price", "Price per day is incorrect"));
        }

        if (object.getCarNumber() == null) {
            validationResult.add(Error.of("invalid.car.number", "Car number is incorrect"));
        }

        return validationResult;
    }
}
