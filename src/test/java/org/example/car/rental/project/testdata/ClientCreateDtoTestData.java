package org.example.car.rental.project.testdata;

import org.example.car.rental.project.dto.CreateClientDto;

public class ClientCreateDtoTestData {

    public static final CreateClientDto VALID_DTO = CreateClientDto.builder()
            .firstName("Test")
            .lastName("Test")
            .email("test@email.com")
            .password("1234567890-asdf")
            .phone("12343567689")
            .passportNumber("1234123")
            .build();

    public static final CreateClientDto INVALID_DTO = CreateClientDto.builder()
            .firstName("")
            .lastName("")
            .email("")
            .password("")
            .phone("")
            .passportNumber("")
            .build();
}