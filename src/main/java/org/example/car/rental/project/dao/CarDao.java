package org.example.car.rental.project.dao;

import lombok.SneakyThrows;
import org.example.car.rental.project.entity.Car;
import org.example.car.rental.project.entity.CarStatus;
import org.example.car.rental.project.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarDao implements Dao<Long, Car> {

    private static final CarDao INSTANCE = new CarDao();

    public static CarDao getInstance() {
        return INSTANCE;
    }

    private static final String FIND_ALL_SQL = """
            SELECT id, brand, model, production_year, price_per_day, car_number, status
            FROM car;
            """;

    private static final String SAVE_SQL = """
            INSERT INTO car(brand, model, production_year, price_per_day, car_number)
            VALUES (?, ?, ?, ?, ?)
            """;

    private static final String FIND_BY_ID_SQL = """
            SELECT id, brand, model, production_year, price_per_day, car_number, status
            FROM car 
            WHERE id = ?
            """;

    private static final String UPDATE_STATUS_BY_ID_SQL = """
            UPDATE car
            SET status = ?::car_status
            WHERE id = ?;
            """;

    @SneakyThrows
    public void updateStatus(Long carId, CarStatus carStatus) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement ps = connection.prepareStatement(UPDATE_STATUS_BY_ID_SQL)) {
            ps.setString(1, carStatus.name());
            ps.setLong(2, carId);

            ps.executeUpdate();
        }
    }

    @Override
    @SneakyThrows
    public Optional<Car> findById(Long id) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement ps = connection.prepareStatement(FIND_BY_ID_SQL)) {
            ps.setLong(1, id);

            ResultSet resultSet = ps.executeQuery();
            Car car = null;
            if (resultSet.next()) {
                car = buildCar(resultSet);
            }

            return Optional.ofNullable(car);
        }
    }

    @Override
    @SneakyThrows
    public Car save(Car entity) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement ps = connection.prepareStatement(
                     SAVE_SQL,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, entity.getBrand());
            ps.setString(2, entity.getModel());
            ps.setInt(3, entity.getProductionYear());
            ps.setBigDecimal(4, entity.getPricePerDay());
            ps.setString(5, entity.getCarNumber());

            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                entity.setId(keys.getLong(1));
            }

            return entity;
        }
    }

    @Override
    public List<Car> findAll() {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement ps = connection.prepareStatement(FIND_ALL_SQL)) {
            ResultSet resultSet = ps.executeQuery();

            List<Car> cars = new ArrayList<>();

            while (resultSet.next()) {
                cars.add(buildCar(resultSet));
            }

            return cars;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Car buildCar(ResultSet resultSet) throws SQLException {
        Car car = Car.builder()
                .id(resultSet.getLong("id"))
                .brand(resultSet.getString("brand"))
                .model(resultSet.getString("model"))
                .productionYear(resultSet.getInt("production_year"))
                .pricePerDay(resultSet.getBigDecimal("price_per_day"))
                .carNumber(resultSet.getString("car_number"))
                .status(CarStatus.valueOf(resultSet.getString("status")))
                .build();

        return car;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Long id) {

    }
}
