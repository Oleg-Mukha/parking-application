package config;

public class Config {
    // Database connection data
    public static final String USER = "root";
    public static final String PASSWORD = "6971";
    public static final String DB_HOST = "localhost";
    public static final String DB_PORT = "3306";
    public static final String DB_NAME = "db_parking";

    // Fields (table: 'owners')
    public static final String FULL_NAME = "full_name";
    public static final String PHONE_NUMBER = "phone_number";

    // Fields (table: 'parking')
    public static final String PARKING_SPOT = "parking_spot";
    public static final String CAR_ID = "car_id";
    public static final String OWNER_ID = "owner_id";

    // Fields (table: 'cars')
    public static final String CAR_BRAND = "car_brand";
    public static final String CAR_NUMBER = "car_number";
    public static final String BODY_TYPE = "car_body";
    public static final String FUEL_TYPE = "car_fuel";
    public static final String ENGINE_VOLUME = "engine_volume";

    // Fields (table: 'fuel_types')
    public static final String FUEL = "fuel";

    // Fields (table: 'car_types')
    public static final String BODY_TYPE_NAME = "body_type";

    // Fields (table: 'car_manufacturers')
    public static final String BRAND = "brand";
    public static final String GROUP = "group";

    // Fields (table: 'manufacturer_groups')
    public static final String GROUP_NAME = "group";
}

