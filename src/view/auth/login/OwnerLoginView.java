package view.auth.login;

import config.ServiceLocator;
import controllers.ownercontrollers.OwnerController;
import models.Owner;
import util.InputUtil;
import util.PropertyFileHandler;
import view.auth.authInterfaces.Login;

public class OwnerLoginView implements Login {
    private static OwnerLoginView olv;

    private OwnerLoginView() {

    }

    public static OwnerLoginView getInstance() {
        if (olv == null) {
            olv = new OwnerLoginView();
        }
        return olv;
    }

    @Override
    public void login() {
        String mobileNumber = InputUtil.UserFormInputUtil.readMobileNumber();
        String password = InputUtil.UserFormInputUtil.readPassword();
        long id;
        if ((id = OwnerController.handleOwnerLogin(new Owner(mobileNumber, password))) != 0) {
            PropertyFileHandler.saveProperty("userId", String.valueOf(id));
            ServiceLocator.getInstance().getOwnerView().view();
        } else {
            System.out.println("❌ Error: We couldn't find an account linked to the entered username/mobile number. Please sign up to create a new account.");
        }
    }
}
