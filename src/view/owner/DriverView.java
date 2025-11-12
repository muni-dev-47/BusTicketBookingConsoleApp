package view.owner;

import config.ServiceLocator;
import util.InputUtil;
import view.View;

import java.sql.SQLException;

public class DriverView implements View {
    private static DriverView driverView;

    private DriverView() {
    }

    public static DriverView getInstance() {
        if (driverView == null) driverView = new DriverView();
        return driverView;
    }

    @Override
    public void view() throws SQLException {
        String[] choices = {"➕ ADD NEW DRIVER", "\uD83D\uDCCB VIEW DRIVER LIST", "⬅\uFE0F BACK"};
        int choice = InputUtil.getMenuChoice("\uD83D\uDC64 DRIVER MANAGEMENT", choices);
        switch (choice) {
            case 1:

            case 2:
                ServiceLocator.getInstance().getDriverListView().view();
                break;
            case 3:
                return;
        }
    }
}
