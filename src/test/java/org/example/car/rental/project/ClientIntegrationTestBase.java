package org.example.car.rental.project;

import lombok.SneakyThrows;
import org.example.car.rental.project.util.ConnectionManager;
import org.junit.jupiter.api.BeforeEach;

public abstract class ClientIntegrationTestBase {

    private static final String CLEAN_SQL = "DROP TABLE IF EXISTS client;";

    private static final String CREATE_SQL = """
            CREATE TABLE IF NOT EXISTS client
            (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                first_name VARCHAR(64),
                last_name VARCHAR(64),
                email VARCHAR(64) NOT NULL UNIQUE,
                password VARCHAR(64) NOT NULL,
                phone VARCHAR(32),
                passport_number VARCHAR(32),
                created_at TIMESTAMP
            );
            """;

    private static final String INSERT_SQL = """
            INSERT INTO client (first_name, last_name, email, password, phone, passport_number, created_at)
            VALUES 
            ('Ivan', 'Ivanov', 'ivan@gmail.com', '111', '+123456', 'AA123456', NOW()),
            ('Petr', 'Petrov', 'petr@gmail.com', '123', '+654321', 'BB654321', NOW()),
            ('Anna', 'Smirnova', 'anna@gmail.com', '222', '+987654', 'CC987654', NOW());
            """;

    @BeforeEach
    @SneakyThrows
    void prepareDatabase() {
        try (var connection = ConnectionManager.get();
             var statement = connection.createStatement()) {

            statement.execute(CLEAN_SQL);
            statement.execute(CREATE_SQL);
            statement.execute(INSERT_SQL);
        }
    }
}