package ru.sberbank.edu.repository;


import ru.sberbank.edu.model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CarDbRepositoryImpl implements CarRepository {
    private final Connection connection;
    private static final String CREATE_CAR_SQL = "INSERT INTO car (id, model) VALUES (?,?)";
    private static final String UPDATE_CAR_SQL = "UPDATE car SET model = ? WHERE id = ?";
    private static final String SELECT_CAR_BY_ID = "SELECT * FROM car WHERE id = ?";
    private static final String SELECT_CAR_BY_MODEL = "SELECT * FROM car WHERE model = ?";
    private static final String SELECT_CAR_ALL = "SELECT * FROM car";
    private static final String SELECT_COUNT_BY_MODEL = "SELECT COUNT(*) FROM car where model = ?";


    private static final String DELETE_CAR_BY_ID = "DELETE FROM car WHERE id = ?";
    private static final String DELETE_CAR_ALL = "DELETE FROM car";

    private final PreparedStatement createPreStmt;
    private final PreparedStatement updatePreStmt;
    private final PreparedStatement findByIdPreStmt;
    private final PreparedStatement deleteById;
    private final PreparedStatement findByModel;
    private final PreparedStatement findCarAll;
    private final PreparedStatement deleteCarAll;

    public CarDbRepositoryImpl(Connection connection) throws SQLException {
        this.connection = connection;
        this.createPreStmt = connection.prepareStatement(CREATE_CAR_SQL);
        this.updatePreStmt = connection.prepareStatement(UPDATE_CAR_SQL);
        this.findByIdPreStmt = connection.prepareStatement(SELECT_CAR_BY_ID);

        this.deleteById = connection.prepareStatement(DELETE_CAR_BY_ID);
        this.findByModel = connection.prepareStatement(SELECT_CAR_BY_MODEL);
        this.deleteCarAll = connection.prepareStatement(DELETE_CAR_ALL);
        this.findCarAll = connection.prepareStatement(SELECT_CAR_ALL);
    }

    @Override
    public Car createOrUpdate(Car car) throws SQLException {
        Optional<Car> optCar = findById(car.getId());
        if (optCar.isEmpty()) {
            createPreStmt.setString(1, car.getId());
            createPreStmt.setString(2, car.getModel());
            createPreStmt.executeUpdate();
        } else {
            updatePreStmt.setString(1, car.getModel());
            updatePreStmt.setString(2, car.getId());
            updatePreStmt.executeUpdate();
        }
        return car;
    }

    /**
     * @param cars
     * @return
     */
    @Override
    public Set<Car> createAll(Collection<Car> cars) throws SQLException {
        Set<Car> carsReturn = new HashSet<>();
        for (Car car : cars ) {
            Optional<Car> optCar = findById(car.getId());
            if (optCar.isEmpty()) {
                createPreStmt.setString(1, car.getId());
                createPreStmt.setString(2, car.getModel());
                createPreStmt.executeUpdate();
            } else {
                updatePreStmt.setString(1, car.getModel());
                updatePreStmt.setString(2, car.getId());
                updatePreStmt.executeUpdate();
            }
            carsReturn.add(car);
        }
        return carsReturn;
    }

    /**
     * @return
     */
    @Override
    public Set<Car> findAll() throws SQLException {
        ResultSet resultSet = findCarAll.executeQuery();
        Set<Car> cars = new HashSet<>();
        while (resultSet.next()) {
            cars.add(new Car(resultSet.getString(1), resultSet.getString(2)));
        }
        return cars;
    }

    @Override
    public Optional<Car> findById(String id) throws SQLException {
        // validation
        int rowsCount = countRowsById(id);
        if (rowsCount > 1) {
            throw new RuntimeException("Car with id = " + id + " was found many times (" + rowsCount + ").");
        } else if (rowsCount == 0) {
            return Optional.empty();
        }

        findByIdPreStmt.setString(1, id);
        ResultSet resultSet = findByIdPreStmt.executeQuery();

        resultSet.next();
        Car car = new Car(resultSet.getString(1), resultSet.getString(2));
        return Optional.of(car);
    }

    @Override
    public Boolean deleteById(String id) throws SQLException {
        deleteById.setString(1, id);
        int returnInt = deleteById.executeUpdate();
        return returnInt > 0 ? true : false;

    }

    /**
     * @return
     */
    @Override
    public Boolean deleteAll() {

        int returnInt = 0;
        try {
            returnInt = deleteCarAll.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return returnInt > 0 ? true : false;
    }

    private int countRowsById(String id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM car where id = ?");
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        int rowCount = 0;
        while (resultSet.next()) {
            rowCount = resultSet.getInt(1);
        }
        return rowCount;
    }

//    private int countRowsByModel(String model) throws SQLException {
//        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COUNT_BY_MODEL);
//        preparedStatement.setString(2, model);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        int rowCount = 0;
//
//        while (resultSet.next()) {
//            rowCount = resultSet.getInt(2);
//        }
//
//        return rowCount;
//    }

    /**
     * @param model
     * @return
     */
    @Override
    public Set<Car> findByModel(String model) throws SQLException {
//        int rowsCount = countRowsByModel(model);
//        if (rowsCount > 1) {
//            throw new RuntimeException("Car with model = " + model + " was found many times (" + rowsCount + ").");
//        } else if (rowsCount == 0) {
//            return null;
//        }

        findByModel.setString(2, model);
        ResultSet resultSet = findByModel.executeQuery();
        Set<Car> cars = new HashSet<>();
        while (resultSet.next()){
            Car car = new Car(resultSet.getString(1), resultSet.getString(2));
            cars.add(car);
        }
        return cars;

    }
}
