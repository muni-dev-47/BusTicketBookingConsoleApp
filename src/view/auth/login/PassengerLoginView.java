package view.auth.login;

import config.ServiceLocator;
import controllers.passengercontrollers.PassengerController;
import models.Passenger;
import util.InputUtil;
import util.PropertyFileHandler;
import view.auth.authInterfaces.Login;

public class PassengerLoginView implements Login {
    private static PassengerLoginView plv;

    private PassengerLoginView() {

    }

    public static PassengerLoginView getInstance() {
        if (plv == null) {
            plv = new PassengerLoginView();
        }
        return plv;
    }

    @Override
    public void login() {
        while (true) {
            String mobileNumber = InputUtil.UserFormInputUtil.readMobileNumber();
            String password = InputUtil.UserFormInputUtil.readPassword();
            long id;
            if ((id = PassengerController.handlePassengerLogin(new Passenger(mobileNumber, password))) != 0) {
                PropertyFileHandler.saveProperty("userId", String.valueOf(id));
                ServiceLocator.getInstance().getPassengerView().view();
            } else {
                System.out.println("❌ Error: We couldn't find an account linked to the entered username/mobile number. Please sign up to create a new account.");
                break;
            }
        }
    }
}
