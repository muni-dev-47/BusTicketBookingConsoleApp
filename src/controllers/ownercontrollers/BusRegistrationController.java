package controllers.ownercontrollers;

import config.ServiceLocator;
import models.Bus;
import models.Seat;
import services.ownerServices.BusRegistrationService;

import java.sql.SQLException;
import java.util.List;

public class BusRegistrationController {
    private static final BusRegistrationService brs = ServiceLocator.getInstance().getBusRegistrationService();

    public static boolean isBusNumberAvailable(String busNo) {
        return brs.isBusNumberAvailable(busNo);
    }

    public static long handleRegisterNewBus(Bus bus, List<Seat> seats) throws SQLException {
        return brs.handleRegisterNewBus(bus, seats);
    }

}
