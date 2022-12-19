package model;

public class Parking {
    int parkingSpot;
    String carBrand;
    String carNumber;
    String ownerFullName;

    public Parking() {
    }

    public Parking(int parkingSpot, String carBrand, String carNumber, String ownerFullName) {
        this.parkingSpot = parkingSpot;
        this.carBrand = carBrand;
        this.carNumber = carNumber;
        this.ownerFullName = ownerFullName;
    }

    public int getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(int parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getOwnerFullName() {
        return ownerFullName;
    }

    public void setOwnerFullName(String ownerFullName) {
        this.ownerFullName = ownerFullName;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "parkingSpot=" + parkingSpot +
                ", carBrand='" + carBrand + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", ownerFullName='" + ownerFullName + '\'' +
                '}';
    }
}
