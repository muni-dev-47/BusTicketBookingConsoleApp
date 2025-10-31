package view.owner;

import controllers.ownercontrollers.BusScheduleController;
import models.Route;
import models.RouteStop;
import util.InputUtil;
import util.PropertyFileHandler;
import view.View;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AddScheduleView implements View {
    private static AddScheduleView asv;

    private AddScheduleView() {
    }

    public static AddScheduleView getInstance() {
        if (asv == null) asv = new AddScheduleView();
        return asv;
    }

    @Override
    public void view() {
        String originCity = InputUtil.ScheduleFormInputUtil.readOriginCity();
        String destinationCity = InputUtil.ScheduleFormInputUtil.readDestinationCity(originCity);
        long userId = Long.parseLong(PropertyFileHandler.getProperty("userId"));
        if (!BusScheduleController.isRouteAvailable(userId, originCity, destinationCity)) {
            System.out.println("❌ ERROR: Route already exists!\n" + "A route from [" + originCity + "] to [" + destinationCity + "]is already defined in the system.\n " + " Please choose a different city pair or edit the existingroute details.");
            return;
        }
        String routeName = InputUtil.ScheduleFormInputUtil.readRouteName();
        double distanceKm = InputUtil.ScheduleFormInputUtil.readRouteDistance();
        double basePrice = InputUtil.ScheduleFormInputUtil.readRouteBasePrice();
        long routeId;
        try {
            if ((routeId = BusScheduleController.handleAddNewRoute(new Route(routeName, originCity, destinationCity, userId, basePrice))) != 0) {
                List<RouteStop> routeStops = InputUtil.ScheduleFormInputUtil.getRouteStopInputs(routeId, originCity, destinationCity);
                try {
                    BusScheduleController.handleAddNewStops(routeStops);
                } catch (SQLException e) {
                    BusScheduleController.handleDeleteForRoute(routeId);
                    throw new RuntimeException(e);
                }
                long driverId = InputUtil.ScheduleFormInputUtil.readDriverId();
                long busId = InputUtil.ScheduleFormInputUtil.readBusId();
                LocalTime startingTime = InputUtil.ScheduleFormInputUtil.readTripTime("Starting", originCity);
                LocalTime endingTime = InputUtil.ScheduleFormInputUtil.readTripEndTime(startingTime, distanceKm, destinationCity);
                LocalDate tripDate = InputUtil.ScheduleFormInputUtil.readValidDateYYYYMMDD("Trip Start");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
