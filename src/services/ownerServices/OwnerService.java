package services.ownerServices;

import config.ServiceLocator;
import models.Owner;
import repository.ownerRepo.AuthRepository;

import java.sql.SQLException;

public class OwnerService {
    private static OwnerService os = null;
    private static final AuthRepository or = ServiceLocator.getInstance().getOwnerRepo();

    private OwnerService() {

    }

    public static OwnerService getInstance() {
        if (os == null) {
            os = new OwnerService();
        }
        return os;
    }

    public boolean isMobileAvailable(String mobileNumber) {
        return !or.findByUserMobileNumber(mobileNumber);
    }

    public long handleOwnerLogin(Owner owner) {
        return or.findUser(owner);
    }

    public boolean isCityAndCompanyNameAvailable(String city, String companyName) {
        return !or.findByCityAndCompanyName(city, companyName);
    }

    public boolean isGSTNumberAvailable(String gstNumber) {
        return !or.findByGSTNumber(gstNumber);
    }

    public long ownerSignUp(Owner owner) throws SQLException {
        return or.save(owner);
    }
}
