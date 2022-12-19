package database.dao;

import model.Parking;

import java.util.ArrayList;

public interface ParkingDAO {
    ArrayList<Parking> showParking();
    String addCarOnParking();
    String updateCarOnParking();
    void removeCarFromParking();
}
