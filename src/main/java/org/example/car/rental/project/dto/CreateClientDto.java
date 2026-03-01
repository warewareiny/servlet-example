package org.example.car.rental.project.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateClientDto {

    String firstName;
    String lastName;
    String email;
    String password;
    String phone;
    String passportNumber;
}
