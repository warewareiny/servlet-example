package org.example.car.rental.project.validator;

import org.example.car.rental.project.dto.UpdateCarDto;

import java.math.BigDecimal;

public class UpdateCarValidator implements Validator<UpdateCarDto> {

    private static final UpdateCarValidator INSTANCE = new UpdateCarValidator();

    public static UpdateCarValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public ValidationResult isValid(UpdateCarDto object) {
        ValidationResult validationResult = new ValidationResult();

        if (object.getBrand() == null || object.getBrand().isEmpty()) {
            validationResult.add(Error.of("invalid.brand", "Brand is invalid"));
        }

        if (object.getModel() == null || object.getModel().isEmpty()) {
            validationResult.add(Error.of("invalid.model", "Model is invalid"));
        }

        if (object.getProductionYear() == null || object.getProductionYear().isEmpty()) {
            validationResult.add(Error.of("invalid.production.year", "Production year is invalid"));
        }

        BigDecimal price = null;
        try {
            price = new BigDecimal(object.getPricePerDay());
            if (price.compareTo(BigDecimal.ZERO) < 0) {
                validationResult.add(Error.of("invalid.price", "Price must be positive"));
            }
        } catch (Exception e) {
            validationResult.add(Error.of("invalid.price", "Price must be a number"));
        }


        if (object.getCarNumber() == null) {
            validationResult.add(Error.of("invalid.car.number", "Car number is incorrect"));
        }

        return validationResult;
    }

    private UpdateCarValidator() {}
}
