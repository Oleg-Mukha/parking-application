package database;

import database.dao.ParkingDAO;
import model.Parking;

import java.sql.*;
import java.util.ArrayList;

import static config.Config.*;
import static queries.QueriesToParkingTable.*;

public class ParkingServiceMySQL implements ParkingDAO {
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
    public ArrayList<Parking> showParking() {
        Connection connection = null;
        Statement statement = null;
        ArrayList<Parking> carsOnParking = new ArrayList<>();

        try {
            connection = this.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SHOW_PARKING);
            while (resultSet.next()) {
                Parking parking = new Parking();
                parking.setParkingSpot(resultSet.getInt(PARKING_SPOT));
                parking.setCarBrand(resultSet.getString(BRAND));
                parking.setCarNumber(resultSet.getString(CAR_NUMBER));
                parking.setOwnerFullName(resultSet.getString(FULL_NAME));
                carsOnParking.add(parking);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            close(connection);
            close(statement);
        }
        return carsOnParking;
    }

    @Override
    public ArrayList<Parking> findCarsByOwner(String owner) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Parking> searchedCars = new ArrayList<>();

        try {
            connection = this.getConnection();
            preparedStatement = connection.prepareStatement(FIND_CARS_BY_OWNER);
            preparedStatement.setString(1, owner);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Parking parking = new Parking();
                parking.setParkingSpot(resultSet.getInt(PARKING_SPOT));
                parking.setCarBrand(resultSet.getString(BRAND));
                parking.setCarNumber(resultSet.getString(CAR_NUMBER));
                parking.setOwnerFullName(resultSet.getString(FULL_NAME));
                searchedCars.add(parking);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            close(connection);
            close(preparedStatement);
        }
        return searchedCars;
    }

    @Override
    public void addCarOnParking(int spot, int carid, int ownerid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = this.getConnection();
            preparedStatement = connection.prepareStatement(ADD_CAR_ON_PARKING, 3);
            preparedStatement.setInt(1, spot);
            preparedStatement.setInt(2, carid);
            preparedStatement.setInt(3, ownerid);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            close(connection);
            close(preparedStatement);
        }
    }

    @Override
    public String updateCarOnParking(int priorspot, int newspot) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = this.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_CAR_ON_PARKING, 2);
            preparedStatement.setInt(1, priorspot);
            preparedStatement.setInt(2, newspot);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            close(connection);
            close(preparedStatement);
        }
        return "Car has been successfully updated!";
    }

    @Override
    public String removeCarFromParking(int carid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = this.getConnection();
            preparedStatement = connection.prepareStatement(REMOVE_CAR_ON_PARKING,1);
            preparedStatement.setInt(1, carid);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            close(connection);
            close(preparedStatement);
        }
        return "Car has been successfully removed!";
    }
}
