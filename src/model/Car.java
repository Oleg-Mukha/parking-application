package model;

public class Car {
    String carBrand;
    String carNumber;
    String bodyType;
    double engineVolume;

    public Car() {
    }

    public Car(String carBrand, String carNumber, String bodyType, double engineVolume) {
        this.carBrand = carBrand;
        this.carNumber = carNumber;
        this.bodyType = bodyType;
        this.engineVolume = engineVolume;
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

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carBrand='" + carBrand + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", engineVolume=" + engineVolume +
                '}';
    }
}
