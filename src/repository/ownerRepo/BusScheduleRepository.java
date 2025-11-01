package repository.ownerRepo;

import models.Route;
import models.RouteStop;
import models.Trip;
import repository.querys.ownerQuerys.BusScheduleQuery;
import util.DBQueryExecutorUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BusScheduleRepository {

    private static BusScheduleRepository bsr;

    private BusScheduleRepository() {

    }

    public static BusScheduleRepository getInstance() {
        if (bsr == null) bsr = new BusScheduleRepository();
        return bsr;
    }

    public boolean findByOriginCityAndDestinationCity(long ownerId, String originCity, String destinationCity) {
        try {
            ResultSet rs = DBQueryExecutorUtil.executeQueryWithResultSet(BusScheduleQuery.FIND_BY_USER_ID_AND_ORIGIN_CITY_AND_DESTINATION_CITY.getQuery(), new ArrayList<>(Arrays.asList(ownerId, originCity, destinationCity)));
            while (rs.next()) {
                return true;
            }
        } catch (SQLException se) {
            System.out.println(se);
        }
        return false;
    }

    public long saveNewRoute(Route route) throws SQLException {
        return DBQueryExecutorUtil.executeInsertAndReturnKey(BusScheduleQuery.INSERT_NEW_ROUTE.getQuery(), new ArrayList<>(Arrays.asList(route.getRouteName(), route.getOriginCity(), route.getDestinationCity(), route.getBasePrice(), route.getOwnerId())));
    }

    public int deleteRoute(long routeId) throws SQLException {
        return DBQueryExecutorUtil.executeUpdateQuery(BusScheduleQuery.DELETE_ROUTE_BY_ID.getQuery(), new ArrayList<>(Collections.singleton(routeId)));
    }

    public int deleteRouteStop(long routeId) throws SQLException {
        return DBQueryExecutorUtil.executeUpdateQuery(BusScheduleQuery.DELETE_ROUTE_STOP_BY_ROUTE_ID.getQuery(), new ArrayList<>(Collections.singleton(routeId)));
    }

    public long saveRouteStop(RouteStop routeStop) throws SQLException {
        return DBQueryExecutorUtil.executeInsertAndReturnKey(BusScheduleQuery.INSERT_ROUTE_STOP.getQuery(), new ArrayList<>(Arrays.asList(routeStop.getRouteId(), routeStop.getStopCity(), routeStop.getStopLocation(), routeStop.getStopOrder(), routeStop.getDistanceFromOriginKm())));
    }

//    public long saveTripSchedule(Trip trip) throws SQLException {
//        return DBQueryExecutorUtil.executeInsertAndReturnKey(BusScheduleQuery.INSERT_TRIP_SCHEDULE.getQuery(), new ArrayList<>(Arrays.asList(trip.getDriverId(), trip.getRouteId(), trip.getBusId(), trip.getTripDate(), trip.getDepartureTime(), trip.getArrivalTime(), trip.getBaseFare())));
//    }
}
