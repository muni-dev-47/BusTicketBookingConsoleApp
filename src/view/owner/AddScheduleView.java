package view.owner;

import controllers.ownercontrollers.BusController;
import controllers.ownercontrollers.BusScheduleController;
import models.Bus;
import models.Route;
import models.RouteStop;
import models.Schedule;
import util.InputUtil;
import util.PropertyFileHandler;
import view.View;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AddScheduleView implements View {
    private static AddScheduleView asv;

    private AddScheduleView() {
    }

    public static AddScheduleView getInstance() {
        if (asv == null) asv = new AddScheduleView();
        return asv;
    }

    @Override
    public void view() throws SQLException {
        String originCity = InputUtil.ScheduleFormInputUtil.readOriginCity();
        String destinationCity = InputUtil.ScheduleFormInputUtil.readDestinationCity(originCity);
        long userId = Long.parseLong(PropertyFileHandler.getProperty("userId"));
        if (!BusScheduleController.isRouteAvailable(userId, originCity, destinationCity)) {
            System.out.println("❌ ERROR: Route already exists!\n" + "A route from [" + originCity + "] to [" + destinationCity + "]is already defined in the system.\n " + " Please choose a different city pair or edit the existingroute details.");
            return;
        }
        String routeName = InputUtil.ScheduleFormInputUtil.readRouteName();
        double basePrice = InputUtil.ScheduleFormInputUtil.readRouteBasePrice();
        long routeId;
        try {
            if ((routeId = BusScheduleController.handleAddNewRoute(new Route(routeName, originCity, destinationCity, userId, basePrice))) != 0) {
                List<RouteStop> routeStops = getRouteStopInputs(routeId, originCity, destinationCity);
                try {
                    BusScheduleController.handleAddNewStops(routeStops);
                } catch (SQLException e) {
                    BusScheduleController.handleDeleteForRoute(routeId);
                    throw new RuntimeException(e);
                }
                long driverId = InputUtil.ScheduleFormInputUtil.readDriverId();
                long busId = InputUtil.ScheduleFormInputUtil.readBusId();
                Bus bus = BusController.getbus(busId);
                double totalDistance = InputUtil.ScheduleFormInputUtil.getTotalDistance(routeStops);
                LocalTime startingTime = InputUtil.ScheduleFormInputUtil.readTripTime("Starting", originCity);
                LocalTime endingTime = InputUtil.ScheduleFormInputUtil.readTripEndTime(startingTime, totalDistance, destinationCity);
                double minTurnaroundTimeHours = bus.getMinTurnaroundTimeHours();
                List<String> days = readSelectedDays();
                try {
                    BusScheduleController.handleAddNewSchedule(new Schedule(busId, driverId, routeId, startingTime, endingTime, totalDistance, minTurnaroundTimeHours), days);
                    System.out.println("✅ SUCCESS: Recurring Schedule has been successfully created and activated. Trips will be generated based on this rule.");
                } catch (SQLException e) {
                    BusScheduleController.handleDeleteForRouteStops(routeId);
                    BusScheduleController.handleDeleteForRoute(routeId);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> readSelectedDays() {
        final String[] VALID_DAYS = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        System.out.println("\n--- 🗓️ Set Recurring Days ---");
        System.out.println("Select the days the trip should run:");
        System.out.println(" (0=SUN, 1=MON, 2=TUE, 3=WED, 4=THU, 5=FRI, 6=SAT)");
        System.out.print("Enter codes separated by commas (e.g., 1,3,5 for Mon, Wed, Fri): ");

        List<String> selectedDays = new ArrayList<>();
        boolean isValid = false;

        while (!isValid) {
            String input = InputUtil.getScanner().nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("❌ Please enter at least one day code.");
                continue;
            }

            try {
                selectedDays.clear();

                List<Integer> codes = Arrays.stream(input.split(",")).map(String::trim).filter(s -> !s.isEmpty()).map(Integer::parseInt) // Number-aaga maaththuradhu
                        .collect(Collectors.toList());

                if (codes.size() != codes.stream().distinct().count()) {
                    throw new IllegalArgumentException("Day codes must be unique.");
                }
                if (codes.stream().anyMatch(c -> c < 0 || c > 6)) {
                    throw new IllegalArgumentException("Day codes must be between 0 (SUN) and 6 (SAT).");
                }

                for (int code : codes) {
                    selectedDays.add(VALID_DAYS[code]);
                }

                isValid = true;

            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter only numbers separated by commas.");
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Validation Error: " + e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("❌ Internal Error: Code outside valid day index.");
            }
        }
        return selectedDays;
    }

    private List<RouteStop> getRouteStopInputs(long routeId, String routeOrigin, String routeDestination) {

        List<RouteStop> allRouteStops = new ArrayList<>();
        int currentStopOrder = 1;
        String continueInput = "Y";

        {
            System.out.println("\n--- 📍 Defining STARTING Point (Order " + currentStopOrder + ") ---");
            System.out.println("City: " + routeOrigin);

            String originLocation = InputUtil.ScheduleFormInputUtil.readStopLocation(routeOrigin);

            RouteStop originStop = new RouteStop(routeId, routeOrigin, originLocation, currentStopOrder, 0);
            allRouteStops.add(originStop);
            System.out.println("✅ Origin Stop " + routeOrigin + " added (Location: " + originLocation + ")");
        }

        currentStopOrder++;

        System.out.println("\n=============================================");
        System.out.println("   📍 Defining Intermediate Route Stops");
        System.out.println("   (Stops between " + routeOrigin + " and " + routeDestination + ")");
        System.out.println("=============================================");

        while (continueInput.equalsIgnoreCase("Y")) {

            String cityName = InputUtil.ScheduleFormInputUtil.readRouteStopCity();
            String stopLocation = InputUtil.ScheduleFormInputUtil.readStopLocation(cityName);
            double distanceFromOriginKm = readStopDistanceFromOrigin();
            if (cityName.equalsIgnoreCase(routeOrigin) || cityName.equalsIgnoreCase(routeDestination)) {
                System.out.println("⚠️ Warning: Origin (" + routeOrigin + ") or Destination (" + routeDestination + ") cannot be added as an intermediate stop. Skipping.");
                continue;
            }

            RouteStop stop = new RouteStop(routeId, cityName, stopLocation, currentStopOrder, distanceFromOriginKm);
            allRouteStops.add(stop);

            System.out.println("✅ Stop " + cityName + " added (Location: " + stopLocation + ") with Order " + currentStopOrder);

            currentStopOrder++;

            continueInput = InputUtil.readValidatedInput("\nDo you want to add another intermediate stop on this route? (Y/N)", s -> s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("N"), "Please enter Y or N.");
        }

        System.out.println("\n--- 📍 Defining END Point (Order " + currentStopOrder + ") ---");
        System.out.println("City: " + routeDestination);

        String destinationLocation = InputUtil.ScheduleFormInputUtil.readStopLocation(routeDestination);
        double distanceFromOriginKm = readStopDistanceFromOrigin();
        RouteStop destinationStop = new RouteStop(routeId, routeDestination, destinationLocation, currentStopOrder, distanceFromOriginKm);
        allRouteStops.add(destinationStop);
        System.out.println("✅ Destination Stop " + routeDestination + " added (Location: " + destinationLocation + ")");

        return allRouteStops;
    }

    private double readStopDistanceFromOrigin() {

        String prompt = ("📏 Enter Stop Distance from Origin (in Km).");

        Predicate<Double> validator = distance -> distance > 0.0 && distance < Double.MAX_VALUE;

        String errorMessage = ("❌ Invalid Stop Distance. Distance must be greater than 0 km and + lessthen" + Double.MAX_VALUE);

        return InputUtil.readValidatedDouble(prompt, validator, errorMessage);
    }
}
