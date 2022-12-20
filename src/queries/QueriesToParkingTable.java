package queries;

public class QueriesToParkingTable {
    public static final String SHOW_PARKING = "SELECT parking_spot, cm.brand, c.car_number, o.full_name FROM parking\n" +
            "inner join owners o on o.id = owner_id inner join cars c on c.id = car_id\n" +
            "inner join car_manufacturers cm on c.car_brand = cm.id";
    // Usage Stored Procedures
    public static final String FIND_CARS_BY_OWNER = "call findCarsByOwner(?)";
    public static final String ADD_CAR_ON_PARKING = "select addingCarOnParking(?, ?, ?)";
    public static final String UPDATE_CAR_ON_PARKING = "call updCarOnParking(?, ?)";
    public static final String REMOVE_CAR_ON_PARKING = "call removeCarFromParking(?)";


}
