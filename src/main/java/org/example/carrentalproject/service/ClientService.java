package org.example.carrentalproject.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.example.carrentalproject.dao.ClientDao;
import org.example.carrentalproject.dto.ClientDto;
import org.example.carrentalproject.dto.CreateClientDto;
import org.example.carrentalproject.entity.Client;
import org.example.carrentalproject.mapper.CreateClientMapper;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientService {

    private static final ClientService INSTANCE = new ClientService();

    private final CreateClientMapper mapper = CreateClientMapper.getInstance();
    private final ClientDao clientDao = ClientDao.getInstance();

    public static ClientService getInstance() {
        return INSTANCE;
    }

    @SneakyThrows
    public Long create(CreateClientDto clientDto) {
        Client clientEntity = mapper.mapFrom(clientDto);
        clientDao.save(clientEntity);

        return clientEntity.getId();
    }

    public Optional<ClientDto> login(String login, String password) {
        return ClientDao.findBy
    }
}
