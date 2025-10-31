package view.auth.login;

import controllers.admincontrollers.AdminController;
import models.User;
import util.InputUtil;
import view.auth.authInterfaces.Login;

public class AdminLoginView implements Login {

    @Override
    public void login() {
        String mobileNumber = InputUtil.UserFormInputUtil.readMobileNumber();
        String password = InputUtil.UserFormInputUtil.readPassword();
        User user = null;
        if ((user = AdminController.loginGetMapping(new User(mobileNumber, password))) != null) {

        }
    }
}
