package view.auth;

import config.ServiceLocator;
import util.InputUtil;
import view.auth.authInterfaces.Login;
import view.auth.authInterfaces.SignUp;

import java.sql.SQLException;

public class AuthView {
    private static AuthView av = null;

    private AuthView() {

    }

    public static AuthView getInstance() {
        if (av == null) {
            av = new AuthView();
        }
        return av;
    }

    public void login() throws SQLException {
        String[] choices = {"PASSENGER LOGIN", "BUSINESS LOGIN", "ADMIN LOGIN", "BACK"};
        int choice = InputUtil.getMenuChoice("LOGIN PAGE", choices);
        Login login;
        switch (choice) {
            case 1:
                login = ServiceLocator.getInstance().getPassengerLoginView();
                login.login();
                break;
            case 2:
                login = ServiceLocator.getInstance().getOwnerLoginView();
                login.login();
                break;
            case 3:
                break;
            case 4:
                return;
        }
    }

    public void signUp() {
        String[] choices = {"PASSENGER SIGNUP", "BUSINESS SIGNUP", "BACK"};
        int choice = InputUtil.getMenuChoice("SIGNUP PAGE", choices);
        SignUp signup;
        switch (choice) {
            case 1:
                signup = ServiceLocator.getInstance().getPassengerSignUpView();
                signup.signUp();
                break;
            case 2:
                signup = ServiceLocator.getInstance().getOwnerSignUpView();
                signup.signUp();
            case 3:

            default:

        }
    }
}
