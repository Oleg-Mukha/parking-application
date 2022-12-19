package config;

public class Config {
    // Database connection data
    public static final String USER = "root";
    public static final String PASSWORD = "6971";
    public static final String DB_HOST = "localhost";
    public static final String DB_PORT = "3306";
    public static final String DB_NAME = "db_parking";

    // Fields (table: 'parking')
    public static final String PARKING_SPOT = "parking_spot";
    public static final String CAR_ID = "car_id";
    public static final String OWNER_ID = "full_name"; // TODO: ! от указанного поля зависит итоговое значение, доделать правильный вывод !


    // Fields (table: 'parking')
    public static final String CAR_NUMBER = "car_number";
}

