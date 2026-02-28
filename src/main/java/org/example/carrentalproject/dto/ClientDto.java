package org.example.carrentalproject.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class ClientDto {

    Long id;
    String firstName;
    String lastName;
    String email;
    String password;
    String phone;
    String passportNumber;
    LocalDateTime createdAt;
}
