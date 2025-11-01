package view.auth.signup;

import config.ServiceLocator;
import controllers.passengercontrollers.PassengerController;
import models.Passenger;
import util.InputUtil;
import util.PasswordHasher;
import util.PropertyFileHandler;
import view.auth.authInterfaces.SignUp;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

public class PassengerSignUpView implements SignUp {
    private static PassengerSignUpView psv;

    private PassengerSignUpView() {

    }

    public static PassengerSignUpView getInstance() {
        if (psv == null) {
            psv = new PassengerSignUpView();
        }
        return psv;
    }

    @Override
    public void signUp() {
        try {
            String mobileNumber = InputUtil.UserFormInputUtil.readMobileNumber();
            if (!PassengerController.isMobileAvailable(mobileNumber)) {
                System.out.println("❌ Error: This mobile number is already registered with an existing account. Please use a different number or try logging in.");
                return;
            }
            String userName = InputUtil.UserFormInputUtil.readName();
            String password = PasswordHasher.hashPassword(InputUtil.UserFormInputUtil.readPassword());
            long id = PassengerController.handlePassengerSignUp(new Passenger(userName, mobileNumber, password));
            PropertyFileHandler.saveProperty("userId", String.valueOf(id));
            ServiceLocator.getInstance().getPassengerView().view();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
