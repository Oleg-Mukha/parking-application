package queries;

public class QueriesToCarTable {
    public static final String SELECT_ALL_CARS_FROM_LIST = "select * from cars";
    public static final String ADD_CAR_TO_CAR_LIST = "select addingCarToCarList(?,?,?,?,?);";
    public static final String FILTER_CARS_BY_REGION = "call selectionCarsByRegion(?);";
}
