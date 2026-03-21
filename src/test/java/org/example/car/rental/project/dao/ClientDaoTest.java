package org.example.car.rental.project.dao;

import org.assertj.core.api.Assertions;
import org.example.car.rental.project.ClientIntegrationTestBase;
import org.example.car.rental.project.entity.Client;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.example.car.rental.project.testdata.ClientTestData.VALID_USER;
import static org.mockito.BDDMockito.then;

public class ClientDaoTest extends ClientIntegrationTestBase {

    private final ClientDao clientDao = ClientDao.getInstance();

    @Test
    @Tag("save")
    void shouldSaveClient() {
        Client savedClient = clientDao.save(VALID_USER);
        assertThat(savedClient.getId()).isNotNull().isPositive();

        assertThat(savedClient)
                .isNotNull()
                .extracting(Client::getEmail, Client::getPhone, Client::getPassword)
                .containsExactly(VALID_USER.getEmail(), VALID_USER.getPhone(), VALID_USER.getPassword());
    }

    @Test
    @Tag("findByEmailAndPassword")
    void shouldReturnExistingPersonWithCorrectData() {
//        todo
    }

    @Test
    @Tag("findByEmailAndPassword")
    void shouldReturnEmptyOptionalIfPasswordOrEmailIsIncorrect() {
//        todo
    }
}