package org.example.car.rental.project;

import lombok.SneakyThrows;
import org.example.car.rental.project.util.ConnectionManager;
import org.junit.jupiter.api.BeforeEach;

public abstract class CarIntegrationTestBase {

    private static final String CLEAN_SQL = "DROP TABLE IF EXISTS car;";

    private static final String CREATE_SQL = """
            CREATE TABLE IF NOT EXISTS car
            (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                brand VARCHAR(64),
                model VARCHAR(64),
                production_year INT,
                price_per_day DECIMAL(10,2),
                car_number VARCHAR(32) UNIQUE,
                status VARCHAR(16)
            );
            """;

    private static final String INSERT_SQL = """
            INSERT INTO car (brand, model, production_year, price_per_day, car_number, status)
            VALUES
            ('Toyota', 'Camry', 2020, 50.00, 'A123BC', 'AVAILABLE'),
            ('BMW', 'X5', 2022, 120.00, 'B456DE', 'RENTED'),
            ('Audi', 'A6', 2019, 80.00, 'C789FG', 'BROKEN');
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