package queries;

public class QueriesToCarTable {
    public static final String ADD_CAR_TO_CAR_LIST = "insert into cars(car_brand, car_number, car_body, car_fuel, engine_volume)" +
            "values(?, ?, ?, ?, ?)";
    public static final String FILTER_CARS_BY_REGION = "call selectionCarsByRegion(?);";
}
