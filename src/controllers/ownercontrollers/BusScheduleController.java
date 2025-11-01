package controllers.ownercontrollers;

import config.ServiceLocator;
import models.Route;
import models.RouteStop;
import models.Trip;
import services.ownerServices.BusScheduleService;

import java.sql.SQLException;
import java.util.List;

public class BusScheduleController {
    private static final BusScheduleService busScheduleService = ServiceLocator.getInstance().getBusScheduleService();

    public static boolean isRouteAvailable(long ownerId, String originCity, String destinationCity) {
        return busScheduleService.isRouteAvailable(ownerId, originCity, destinationCity);
    }

    public static long handleAddNewRoute(Route route) throws SQLException {
        return busScheduleService.handleAddNewRoute(route);
    }

    public static boolean handleDeleteForRoute(long routeId) throws SQLException {
        return busScheduleService.handleDeleteForRoute(routeId);
    }

    public static boolean handleDeleteForRouteStops(long routeId) throws SQLException {
        return busScheduleService.handleDeleteForRouteStops(routeId);
    }

    public static boolean handleAddNewStops(List<RouteStop> routeStops) throws SQLException {
        return busScheduleService.handleAddNewStops(routeStops);
    }

//    public static long handleAddNewTripSchedule(Trip trip) throws SQLException {
//        return busScheduleService.handleAddNewTripSchedule(trip);
//    }
}
