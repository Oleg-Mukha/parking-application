package database;

import database.dao.CarDAO;
import model.Car;
import model.Parking;

import java.sql.*;
import java.util.ArrayList;

import static config.Config.*;
import static queries.QueriesToCarTable.*;
import static queries.QueriesToParkingTable.SHOW_PARKING;

public class CarServiceMySQL implements CarDAO {
    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME, USER, PASSWORD);
        } catch (ClassNotFoundException exception) {
            System.out.println("Driver not loaded!");
            exception.printStackTrace();
        } catch (SQLException exception) {
            System.out.println("Connection not established!");
            exception.printStackTrace();
        }
        return connection;
    }

    private static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
                throw new RuntimeException(exception);
            }
        }

    }

    private static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
                throw new RuntimeException(exception);
            }
        }
    }

    @Override
    public ArrayList<Car> showCarList() {
        Connection connection = null;
        Statement statement = null;
        ArrayList<Car> carList = new ArrayList<>();

        try {
            connection = this.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CARS_FROM_LIST);
            while (resultSet.next()) {
                Car car = new Car();
                car.setCarBrand(resultSet.getInt(CAR_BRAND));
                car.setCarNumber(resultSet.getString(CAR_NUMBER));
                car.setBodyType(resultSet.getInt(BODY_TYPE));
                car.setFuelType(resultSet.getInt(FUEL_TYPE));
                car.setEngineVolume(resultSet.getFloat(ENGINE_VOLUME));
                carList.add(car);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            close(connection);
            close(statement);
        }
        return carList;
    }

    @Override
    public void addCarToCarList(Car car) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = this.getConnection();
            preparedStatement = connection.prepareStatement(ADD_CAR_TO_CAR_LIST, 5);
            preparedStatement.setInt(1, car.getCarBrand());
            preparedStatement.setString(2, car.getCarNumber());
            preparedStatement.setInt(3, car.getBodyType());
            preparedStatement.setInt(4, car.getFuelType());
            preparedStatement.setFloat(5, car.getEngineVolume());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            close(connection);
            close((Statement) preparedStatement);
        }
    }

    @Override
    public ArrayList<Car> filterCarsByRegion(String regionChars) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Car> searchedCars = new ArrayList<>();
        try {
            connection = this.getConnection();
            preparedStatement = connection.prepareStatement(FILTER_CARS_BY_REGION, 1);
            preparedStatement.setString(1, regionChars);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Car car = new Car();
                car.setCarBrand(resultSet.getInt(CAR_BRAND));
                car.setCarNumber(resultSet.getString(CAR_NUMBER));
                car.setBodyType(resultSet.getInt(BODY_TYPE));
                car.setFuelType(resultSet.getInt(FUEL_TYPE));
                car.setEngineVolume(resultSet.getFloat(ENGINE_VOLUME));
                searchedCars.add(car);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            close(connection);
            close(preparedStatement);
        }
        return searchedCars;
    }
}
