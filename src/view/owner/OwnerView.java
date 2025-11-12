package view.owner;

import config.ServiceLocator;
import util.InputUtil;
import view.View;

import java.sql.SQLException;


public class OwnerView implements View {
    private static OwnerView ov;

    private OwnerView() {
    }

    public static OwnerView getInstance() {
        if (ov == null) ov = new OwnerView();
        return ov;
    }

    @Override
    public void view() throws SQLException {
        while (true) {
            String[] choices = {"\uD83D\uDE8D BUS & INVENTORY MANAGEMENT", "\uD83D\uDDFA\uFE0F TRIP & SCHEDULE MANAGEMENT", "\uD83D\uDCCA BOOKING & REVENUE MONITORING", "\uD83D\uDC64 ACCOUNT & PROFILE"};
            int choice = InputUtil.getMenuChoice("\uD83D\uDE8C BUS OWNER MANAGEMENT SYSTEM", choices);
            switch (choice) {
                case 1:
                    ServiceLocator.getInstance().getBusAndInventoryView().view();
                    break;
                case 2:
                    ServiceLocator.getInstance().getTripAndScheduleManagementView().view();
                    break;
                case 3:
                case 4:
            }
        }
    }
}
