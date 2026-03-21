package org.example.car.rental.project.testdata;

import org.example.car.rental.project.entity.Client;

public class ClientTestData {

    public static final Client VALID_USER = Client.builder()
            .id(6L)
            .firstName("Test")
            .lastName("Test")
            .email("test@email.com")
            .phone("12343567689")
            .passportNumber("1234123")
            .password("1234567890-asdf")
            .build();

    public static final Client DUMMY = Client.builder()
            .id(5L)
            .firstName("")
            .lastName("")
            .email("")
            .phone("")
            .passportNumber("")
            .password("")
            .build();

}
