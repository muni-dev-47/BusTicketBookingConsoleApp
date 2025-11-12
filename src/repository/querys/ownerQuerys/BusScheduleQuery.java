package repository.querys.ownerQuerys;

public enum BusScheduleQuery {
    FIND_BY_USER_ID_AND_ORIGIN_CITY_AND_DESTINATION_CITY("SELECT * FROM ROUTE WHERE userId = ? AND ORIGINCITY = ? AND DESTINATIONCITY = ?"),
    INSERT_NEW_ROUTE("INSERT INTO Route (routeName, originCity, destinationCity, basePrice, userId) VALUES (?, ?, ?, ?, ?) RETURNING routeId;"),
    DELETE_ROUTE_BY_ID("DELETE FROM ROUTE WHERE ROUTEID = ?"),
    DELETE_ROUTE_STOP_BY_ROUTE_ID("DELETE FROM ROUTESTOP WHERE ROUTEID = ?"),
    INSERT_ROUTE_STOP("INSERT INTO routeStop (routeId , stopCity , stopLocation , stopOrder , distanceFromOriginKm ) VALUES (?,?,?,?,?)"),
    FIND_BUD_BY_ID("SELECT * FROM BUS WHERE busId = ?"),
    FIND_DRIVER_BY_ID("SELECT * FROM SCHEDULE WHERE driverId = ?"),
    INSERT_NEW_SCHEDULE("INSERT INTO SCHEDULE (bus_id , driver_id , route_id , starting_time , ending_time , total_travel_time_min , total_distance_km , rest_time_minutes , day) VALUES (?,?,?,?,?,?,?,?,?) RETURNING schedule_Id");
    //    INSERT_TRIP_SCHEDULE("INSERT INTO TRIP (driverId , routeId , busId , tripDate , departureTime , arrivalTime , baseFare )");
    private final String query;

    BusScheduleQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
