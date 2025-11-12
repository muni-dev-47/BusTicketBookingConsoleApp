package services.ownerServices;

import config.ServiceLocator;
import models.Driver;
import repository.ownerRepo.DriverRepository;

import java.sql.SQLException;
import java.util.List;

public class DriverService {
    private static DriverService driverService;
    private static final DriverRepository driverRepository = ServiceLocator.getInstance().getDriverRepository();

    private DriverService() {
    }

    public static DriverService getInstance() {
        if (driverService == null) driverService = new DriverService();
        return driverService;
    }

    public boolean isDriverAvailable(long driverId) throws SQLException {
        return driverRepository.findDriverById(driverId);
    }

    public List<Driver> getAllDriver(long userId) throws SQLException {
        return driverRepository.getAllDriverList(userId);
    }
}
