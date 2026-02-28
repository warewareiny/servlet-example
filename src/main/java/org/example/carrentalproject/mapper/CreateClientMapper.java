package org.example.carrentalproject.mapper;

import org.example.carrentalproject.dto.CreateClientDto;
import org.example.carrentalproject.entity.Client;

public class CreateClientMapper implements Mapper<CreateClientDto, Client> {

    private static final CreateClientMapper INSTANCE = new CreateClientMapper();

    public static CreateClientMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public Client mapFrom(CreateClientDto object) {
        return Client.builder()
                .firstName(object.getFirstName())
                .lastName(object.getLastName())
                .email(object.getEmail())
                .phone(object.getPhone())
                .passportNumber(object.getPassportNumber())
                .build();
    }

    private CreateClientMapper() {}
}
