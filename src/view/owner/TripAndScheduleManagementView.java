package view.owner;

import config.ServiceLocator;
import util.InputUtil;
import view.View;

import java.sql.SQLException;

public class TripAndScheduleManagementView implements View {
    private static TripAndScheduleManagementView tripAndScheduleView;

    private TripAndScheduleManagementView() {

    }

    public static TripAndScheduleManagementView getInstance() {
        if (tripAndScheduleView == null) tripAndScheduleView = new TripAndScheduleManagementView();
        return tripAndScheduleView;
    }

    @Override
    public void view() throws SQLException {
        while (true) {
            String[] choices = {"📅 CREATE NEW TRIP SCHEDULE (ASSIGN BUS AND TIME)", "📝 VIEW OR MODIFY EXISTING TRIPS", "✖️ CANCEL UPCOMING TRIP", "💵 SET OR UPDATE TICKET FARES", "⬅\uFE0F BACK"};
            int choice = InputUtil.getMenuChoice("\uD83D\uDDFA\uFE0F TRIP & SCHEDULE MANAGEMENT", choices);
            switch (choice) {
                case 1:
                    ServiceLocator.getInstance().getAddScheduleView().view();
                    break;
                case 2:

                case 3:
                case 4:
                case 5:
                    return;
            }
        }
    }
}

