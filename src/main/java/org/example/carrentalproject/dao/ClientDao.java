package org.example.carrentalproject.dao;

import lombok.SneakyThrows;
import org.example.carrentalproject.entity.Client;
import org.example.carrentalproject.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
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
                INSERT INTO client(first_name, last_name, email, phone, passport_number)
                VALUES (?, ?, ?, ?, ?)
                RETURNING id, created_at;
                """;

    @Override
    @SneakyThrows
    public Client save(Client entity) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement ps = connection.prepareStatement(SAVE_SQL)) {
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setString(3, entity.getEmail());
            ps.setString(4, entity.getPhone());
            ps.setString(5, entity.getPassportNumber());

            try (ResultSet resultSet = ps.executeQuery();) {
                if (resultSet.next()) {
                    entity.setId(resultSet.getLong("id"));
                    entity.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
                }
            }

            return entity;
        }

    }

    public static ClientDao getInstance() {
        return INSTANCE;
    }

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
    public void update(Long id) {

    }

}
