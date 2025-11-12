package repository.querys.ownerQuerys;

public enum DriverQuery {
    FIND_BY_DRIVER_ID("SELECT *  FROM DRIVER WHERE driverId = ?"),
    GET_ALL_DRIVER("SELECT driverId , fullname  FROM DRIVER where userId = ? ");

    private final String query;

    DriverQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
