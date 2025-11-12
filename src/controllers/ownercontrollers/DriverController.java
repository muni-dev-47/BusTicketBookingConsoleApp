package controllers.ownercontrollers;

import config.ServiceLocator;
import models.Driver;
import services.ownerServices.DriverService;

import java.sql.SQLException;
import java.util.List;

public class DriverController {
    private static final DriverService driverService = ServiceLocator.getInstance().getDriverService();

    private DriverController() {
    }

    public static boolean isDriverAvailable(long driverId) throws SQLException {
        return driverService.isDriverAvailable(driverId);
    }

    public static List<Driver> getAllDriverList(long userId) throws SQLException {
        return driverService.getAllDriver(userId);
    }
}
