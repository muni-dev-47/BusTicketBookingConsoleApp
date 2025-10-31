package controllers.ownercontrollers;

import config.ServiceLocator;
import models.Owner;
import services.ownerServices.OwnerService;

import java.sql.SQLException;

public class OwnerController {

    private final static OwnerService os = ServiceLocator.getInstance().getOwnerService();

    private OwnerController() {

    }

    public static long handleOwnerLogin(Owner owner) {
        return os.handleOwnerLogin(owner);
    }

    public static long handlePassengerSignUp(Owner owner) throws SQLException {
        return os.ownerSignUp(owner);
    }

    public static boolean isMobileAvailable(String mobileNumber) {
        return os.isMobileAvailable(mobileNumber);
    }

    public static boolean isCityAndCompanyNameAvailable(String city, String companyName) {
        return os.isCityAndCompanyNameAvailable(city, companyName);
    }

    public static boolean isGSTNumberAvailable(String gstNumber) {
        return os.isGSTNumberAvailable(gstNumber);
    }


}
