package org.example.carrentalproject.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateClientDto {

    String firstName;
    String lastName;
    String email;
    String phone;
    String passportNumber;
}
