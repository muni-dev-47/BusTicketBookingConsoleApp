package controllers.ownercontrollers;

import config.ServiceLocator;
import models.Bus;
import models.Seat;
import services.ownerServices.BusService;

import java.sql.SQLException;
import java.util.List;

public class BusController {
    private static final BusService brs = ServiceLocator.getInstance().getBusRegistrationService();

    public static boolean isBusNumberAvailable(String busNo) {
        return brs.isBusNumberAvailable(busNo);
    }

    public static long handleRegisterNewBus(Bus bus, List<Seat> seats) throws SQLException {
        return brs.handleRegisterNewBus(bus, seats);
    }

    public static Bus getbus(long busId) throws SQLException {
        return brs.getBus(busId);
    }

    public static List<Bus> getAllBus(long userId) throws SQLException {
        return brs.getAllBus(userId);
    }
}
