package repository.querys.ownerQuerys;

public enum BusScheduleQuery {
    FIND_BY_USER_ID_AND_ORIGIN_CITY_AND_DESTINATION_CITY("SELECT * FROM ROUTE WHERE userId = ? AND ORIGINCITY = ? AND DESTINATIONCITY = ?"),
    INSERT_NEW_ROUTE("INSERT INTO Route (routeName, originCity, destinationCity, basePrice, userId) VALUES (?, ?, ?, ?, ?, ?) RETURNING routeId;"),
    DELETE_ROUTE_BY_ID("DELETE FROM ROUTE WHERE ROUTEID = ?"),
    DELETE_ROUTE_STOP_BY_ROUTE_ID("DELETE FROM ROUTESTOP WHERE ROUTEID = ?"),
    INSERT_ROUTE_STOP("INSERT INTO routeStop (routeId , stopCity , stopLocation , stopOrder , distanceFromOriginKm ) VALUES (?,?,?,?,?)");
//    INSERT_TRIP_SCHEDULE("INSERT INTO TRIP (driverId , routeId , busId , tripDate , departureTime , arrivalTime , baseFare )");
    private final String query;

    BusScheduleQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
