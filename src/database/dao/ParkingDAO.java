package database.dao;

import model.Parking;

import java.util.ArrayList;

public interface ParkingDAO {
    ArrayList<Parking> showParking();
    ArrayList<Parking> findCarsByOwner(String owner);

    String addCarOnParking(int spot, int carid, int ownerid);
    String updateCarOnParking(int priorspot, int newspot);
    String removeCarFromParking(int carid);
}
