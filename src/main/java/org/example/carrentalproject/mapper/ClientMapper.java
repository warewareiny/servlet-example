package org.example.carrentalproject.mapper;

import org.example.carrentalproject.dao.ClientDao;
import org.example.carrentalproject.dto.ClientDto;
import org.example.carrentalproject.entity.Client;

public class ClientMapper implements Mapper<Client, ClientDto> {

    private static final ClientMapper INSTANCE = new ClientMapper();

    public static ClientMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public ClientDto mapFrom(Client client) {
        return ClientDto.builder()
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .email(client.getEmail())
                .password(client.getPassword())
                .phone(client.getPhone())
                .passportNumber(client.getPassportNumber())
                .createdAt(client.getCreatedAt())
                .build();
    }
}
