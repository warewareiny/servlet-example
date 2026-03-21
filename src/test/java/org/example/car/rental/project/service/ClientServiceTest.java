package org.example.car.rental.project.service;

import org.example.car.rental.project.ClientIntegrationTestBase;
import org.example.car.rental.project.dto.ClientDto;
import org.example.car.rental.project.exception.ValidationException;
import org.example.car.rental.project.testdata.ClientCreateDtoTestData;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ClientServiceTest extends ClientIntegrationTestBase {

    private final ClientService clientService = ClientService.getInstance();

    @Test
    @Tag("login")
    void shouldReturnCorrectClient() {
        Optional<ClientDto> result = clientService.login("ivan@gmail.com", "111");

        assertTrue(result.isPresent());
        assertEquals("Ivan", result.get().getFirstName());
        assertEquals("Ivanov", result.get().getLastName());
        assertEquals("ivan@gmail.com", result.get().getEmail());
    }

    @Test
    @Tag("login")
    void shouldReturnEmptyOptionalIfDataIsIncorrect() {
        Optional<ClientDto> result = clientService.login("wrong@gmail.com", "wrong");

        assertTrue(result.isEmpty());
    }

    @Test
    @Tag("create")
    void shouldCreateValidClient() {
        Long clientId = clientService.create(ClientCreateDtoTestData.VALID_DTO);

        assertNotNull(clientId);

        Optional<ClientDto> createdClient = clientService.login(
                ClientCreateDtoTestData.VALID_DTO.getEmail(),
                ClientCreateDtoTestData.VALID_DTO.getPassword()
        );

        assertTrue(createdClient.isPresent());
        assertEquals(ClientCreateDtoTestData.VALID_DTO.getEmail(), createdClient.get().getEmail());
    }

    @Test
    @Tag("create")
    void throwExceptionIfDataIsIncorrect() {
        assertThrows(
                ValidationException.class,
                () -> clientService.create(ClientCreateDtoTestData.INVALID_DTO)
        );
    }
}