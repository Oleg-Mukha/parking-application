package model;

public class Car {
    int carBrand;
    String carNumber;
    int bodyType;
    int fuelType;
    float engineVolume;

    public Car() {
    }

    public Car(int carBrand, String carNumber, int bodyType, int fuelType, float engineVolume) {
        this.carBrand = carBrand;
        this.carNumber = carNumber;
        this.bodyType = bodyType;
        this.fuelType = fuelType;
        this.engineVolume = engineVolume;
    }

    public int getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(int carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public int getBodyType() {
        return bodyType;
    }

    public void setBodyType(int bodyType) {
        this.bodyType = bodyType;
    }

    public int getFuelType() {
        return fuelType;
    }

    public void setFuelType(int fuelType) {
        this.fuelType = fuelType;
    }

    public float getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(float engineVolume) {
        this.engineVolume = engineVolume;
    }

    @Override
    public String toString() {
        return "Brand id: " + carBrand + " | Car number: " + carNumber + " | Body type id: " + bodyType + " | Engine capacity: " + engineVolume + "\n";
    }
}
