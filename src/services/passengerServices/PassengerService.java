package services.passengerServices;

import config.ServiceLocator;
import models.User;
import repository.passengerRepo.AuthRepository;
import java.sql.SQLException;

public class PassengerService {
    private static PassengerService ps = null;
    private final static AuthRepository pr = ServiceLocator.getInstance().getPassengerAuthRepo();

    private PassengerService() {
    }

    public static PassengerService getInstance() {
        if (ps == null) {
            ps = new PassengerService();
        }
        return ps;
    }

    public long PassengerSignUp(User user) throws SQLException {
        return pr.save(user);
    }

    public boolean isMobileAvailable(String mobileNumber) {
        return !pr.findByUserMobileNumber(mobileNumber);
    }

    public long PassengerLogin(User user) {
        return pr.findUser(user);
    }
}
