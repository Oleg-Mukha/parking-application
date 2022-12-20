package database.dao;

import model.Car;
import model.Parking;

import java.util.ArrayList;

public interface CarDAO {
    String addCarToCarList(Car car);
    ArrayList<Car> filterCarsByRegion(String regionChars);
}
