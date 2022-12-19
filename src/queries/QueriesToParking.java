package queries;

public class QueriesToParking {
    public static final String SHOW_PARKING = "SELECT parking_spot, car_id, owner_id, c.car_brand, c.car_number, o.full_name FROM parking inner join cars c on c.id = car_id inner join owners o on o.id = owner_id";
           // "INNER JOIN cars c ON c.id = car_id INNER JOIN owners o ON o.id = owner_id";
}
