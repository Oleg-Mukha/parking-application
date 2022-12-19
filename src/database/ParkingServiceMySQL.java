package database;

import database.dao.ParkingDAO;
import model.Parking;

import java.sql.*;
import java.util.ArrayList;

import static config.Config.*;
import static queries.QueriesToParking.*;

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
                parking.setCarBrand(resultSet.getInt(CAR_ID));
                parking.setCarNumber(resultSet.getString(CAR_NUMBER));
                parking.setOwnerFullName(resultSet.getString(OWNER_ID));
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
    public String addCarOnParking() {
        return null;
    }

    @Override
    public String updateCarOnParking() {
        return null;
    }

    @Override
    public void removeCarFromParking() {

    }
}
