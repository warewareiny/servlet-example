package org.example.car.rental.project.dao;

import lombok.SneakyThrows;
import org.example.car.rental.project.entity.Car;
import org.example.car.rental.project.entity.Client;
import org.example.car.rental.project.util.ConnectionManager;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class ClientDao implements Dao<Long, Client> {

    private static final ClientDao INSTANCE = new ClientDao();

    private static final String FIND_BY_ID_SQL = """
            SELECT id, first_name, last_name, email, phone, passport_number, created_at
            FROM client
            WHERE id = ?
            """;

    private static final String DELETE_SQL = """
            DELETE FROM client WHERE id = ?
            """;

    private static final String UPDATE_SQL = """
            UPDATE client
            SET first_name = ?,
                last_name = ?,
                email = ?,
                phone = ?,
                passport_number = ?
            WHERE id = ?
            """;
    private static final String SAVE_SQL = """
            INSERT INTO client(first_name, last_name, email, phone, passport_number, password, created_at)
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;
    private static final String FIND_BY_EMAIL_AND_PASSWORD_SQL = """
          SELECT id, first_name, last_name, email, password, phone, passport_number, created_at
          FROM client
          WHERE email = ? AND password = ?
          """;

    @Override
    public List<Client> findAll() {
        return List.of();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean update(Client entity) {
        return false;
    }

    @Override
    @SneakyThrows
    public Client save(Client entity) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement ps = connection.prepareStatement(
                     SAVE_SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setString(3, entity.getEmail());
            ps.setString(4, entity.getPhone());
            ps.setString(5, entity.getPassportNumber());
            ps.setString(6, entity.getPassword());
            ps.setTimestamp(7, Timestamp.valueOf(entity.getCreatedAt()));

            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    entity.setId(keys.getLong(1));
                }
            }

            return entity;
        }
    }

    @SneakyThrows
    public Optional<Client> findByEmailAndPassword(String email, String password) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement ps = connection.prepareStatement(FIND_BY_EMAIL_AND_PASSWORD_SQL)) {
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet resultSet = ps.executeQuery();
            Client client = null;
            if (resultSet.next()) {
                client = buildEntity(resultSet);
            }
            return Optional.ofNullable(client);
            }
        }

    private static Client buildEntity(ResultSet resultSet) throws SQLException {
        Client client;
        client = Client.builder()
                .id(resultSet.getLong("id"))
                .firstName(resultSet.getString("first_name"))
                .lastName(resultSet.getString("last_name"))
                .email(resultSet.getString("email"))
                .phone(resultSet.getString("phone"))
                .passportNumber(resultSet.getString("passport_number"))
                .createdAt(resultSet.getTimestamp("created_at").toLocalDateTime())
                .password(resultSet.getString("password"))
                .build();
        return client;
    }

    public static ClientDao getInstance() {
        return INSTANCE;
    }
}