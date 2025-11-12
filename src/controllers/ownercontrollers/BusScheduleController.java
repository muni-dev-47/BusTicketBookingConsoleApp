package controllers.ownercontrollers;

import config.ServiceLocator;
import models.Route;
import models.RouteStop;
import models.Schedule;
import services.ownerServices.BusScheduleService;

import java.sql.SQLException;
import java.util.List;

public class BusScheduleController {
    private static final BusScheduleService busScheduleService = ServiceLocator.getInstance().getBusScheduleService();

    public static boolean isRouteAvailable(long ownerId, String originCity, String destinationCity) throws SQLException {
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

    public static boolean isBusAvailable(long busId) throws SQLException {
        return busScheduleService.isBusAvailable(busId);
    }

    public static boolean isDriverAvailable(long driverId) throws SQLException {
        return DriverController.isDriverAvailable(driverId) && busScheduleService.isDriverAvailable(driverId);
    }

    public static void handleAddNewSchedule(Schedule schedule, List<String> days) throws SQLException {
        busScheduleService.handleAddNewSchedule(schedule, days);
    }
//    public static long handleAddNewTripSchedule(Trip trip) throws SQLException {
//        return busScheduleService.handleAddNewTripSchedule(trip);
//    }
}
