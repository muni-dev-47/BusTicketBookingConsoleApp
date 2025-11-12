package view;

import config.ServiceLocator;
import util.InputUtil;
import view.auth.AuthView;

import java.sql.SQLException;

public class TicketBookingApplication {
    public static void main() throws SQLException {
        AuthView av = ServiceLocator.getInstance().getAuthView();
        while (true) {
            int choice = InputUtil.getMenuChoice("WELCOME TO MY APPLICATION", new String[]{"LOGIN", "SIGNUP", "EXIT"});
            switch (choice) {
                case 1:
                    av.login();
                    break;
                case 2:
                    av.signUp();
                    break;
                case 3:
                    return;
            }
        }
    }
}
