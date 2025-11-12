package services.ownerServices;

import config.ServiceLocator;
import models.*;
import repository.ownerRepo.BusScheduleRepository;

import java.sql.SQLException;
import java.util.List;

public class BusScheduleService {

    private static BusScheduleService busScheduleService;
    private static final BusScheduleRepository busScheduleRepository = ServiceLocator.getInstance().getBusScheduleRepository();

    private BusScheduleService() {

    }

    public static BusScheduleService getInstance() {
        if (busScheduleService == null) busScheduleService = new BusScheduleService();
        return busScheduleService;
    }

    public boolean isRouteAvailable(long ownerId, String originCity, String destinationCity) throws SQLException {
        return !busScheduleRepository.findByOriginCityAndDestinationCity(ownerId, originCity, destinationCity);
    }

    public long handleAddNewRoute(Route route) throws SQLException {
        return busScheduleRepository.saveNewRoute(route);
    }

    public boolean handleDeleteForRoute(long routeId) throws SQLException {
        return 0 != (busScheduleRepository.deleteRoute(routeId));
    }

    public boolean handleDeleteForRouteStops(long routeId) throws SQLException {
        return 0 != busScheduleRepository.deleteRouteStop(routeId);
    }

    public boolean handleAddNewStops(List<RouteStop> routeStops) throws SQLException {
        for (int i = 0; i < routeStops.size(); i++) {
            busScheduleRepository.saveRouteStop(routeStops.get(i));
        }
        return true;
    }

    public boolean isBusAvailable(long busId) throws SQLException {
        return !busScheduleRepository.findBusById(busId);
    }

    public boolean isDriverAvailable(long driverId) throws SQLException {
        return !busScheduleRepository.findDriverById(driverId);
    }

    public void handleAddNewSchedule(Schedule schedule, List<String> days) throws SQLException {
        for (String day : days) {
            schedule.setDay(day);
            busScheduleRepository.saveNewSchedule(schedule);
        }
    }


//    public long handleAddNewTripSchedule(Trip trip) throws SQLException {
//        return busScheduleRepository.saveTripSchedule(trip);
//    }

}
