package database.dao;

import model.Car;
import model.Parking;

import java.util.ArrayList;

public interface CarDAO {
    ArrayList<Car> showCarList();
    void addCarToCarList(Car car);
    ArrayList<Car> filterCarsByRegion(String regionChars);
}
