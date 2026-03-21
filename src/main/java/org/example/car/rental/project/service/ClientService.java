package org.example.car.rental.project.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.example.car.rental.project.dao.ClientDao;
import org.example.car.rental.project.exception.ValidationException;
import org.example.car.rental.project.mapper.CreateClientMapper;
import org.example.car.rental.project.dto.ClientDto;
import org.example.car.rental.project.dto.CreateClientDto;
import org.example.car.rental.project.entity.Client;
import org.example.car.rental.project.mapper.ClientMapper;
import org.example.car.rental.project.validator.CreateClientValidator;
import org.example.car.rental.project.validator.ValidationResult;

import java.time.LocalDateTime;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientService {

    private static final ClientService INSTANCE = new ClientService();

    private final CreateClientMapper createClientMapper = CreateClientMapper.getInstance();
    private final CreateClientValidator createClientValidator = CreateClientValidator.getInstance();
    private final ClientMapper clientMapper = ClientMapper.getInstance();
    private final ClientDao clientDao = ClientDao.getInstance();

    public static ClientService getInstance() {
        return INSTANCE;
    }

    @SneakyThrows
    public Long create(CreateClientDto clientDto) {
        ValidationResult validationResult = createClientValidator.isValid(clientDto);

        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }

        Client clientEntity = createClientMapper.mapFrom(clientDto);
        clientEntity.setCreatedAt(LocalDateTime.now());
        clientDao.save(clientEntity);

        return clientEntity.getId();
    }

    public Optional<ClientDto> login(String email, String password) {
        return clientDao.findByEmailAndPassword(email, password)
                .map(clientMapper::mapFrom);
    }
}
