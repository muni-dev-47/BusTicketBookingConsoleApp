package controllers.passengercontrollers;

import config.ServiceLocator;
import models.User;
import services.passengerServices.PassengerService;

import java.sql.SQLException;

public class PassengerController {
    private static final PassengerService ps = ServiceLocator.getInstance().getPassengerService();

    private PassengerController() {

    }

    public static long handlePassengerLogin(User user) {
        return ps.PassengerLogin(user);
    }

    public static long handlePassengerSignUp(User user) throws SQLException {
        return ps.PassengerSignUp(user);
    }

    public static boolean isMobileAvailable(String mobileNumber) {
        return ps.isMobileAvailable(mobileNumber);
    }


}
