package org.example.car.rental.project.validator;

import org.example.car.rental.project.dto.CreateClientDto;

public class CreateClientValidator implements Validator<CreateClientDto> {

    private static final CreateClientValidator INSTANCE = new CreateClientValidator();

    @Override
    public ValidationResult isValid(CreateClientDto object) {
        ValidationResult validationResult = new ValidationResult();

        if (object.getLastName() == null || object.getFirstName() == null
                || object.getLastName().isEmpty() || object.getFirstName().isEmpty()) {
            validationResult.add(Error.of("invalid.name", "First name or Last name is invalid"));
        }

        if (object.getPassword() == null || object.getPassword().isEmpty()) {
            validationResult.add(Error.of("invalid.password", "Password is invalid"));
        }

        if (object.getEmail() == null || object.getEmail().isEmpty()) {
            validationResult.add(Error.of("invalid.email", "Email is null"));
        }

        if (object.getPhone() == null || object.getPhone().length() < 10) {
            validationResult.add(Error.of("invalid.phone.number", "Phone is invalid"));
        }

        if (object.getPassportNumber() == null || object.getPassportNumber().isEmpty()) {
            validationResult.add(Error.of("invalid.passport.number", "Passport number is invalid"));
        }

        return validationResult;
    }

    public static CreateClientValidator getInstance() {
        return INSTANCE;
    }
}
