package view.owner;

import config.ServiceLocator;
import controllers.ownercontrollers.BusController;
import models.Bus;
import util.InputUtil;
import util.PropertyFileHandler;
import view.View;

import java.sql.SQLException;
import java.util.List;

public class BusAndInventoryManagementView implements View {
    private static BusAndInventoryManagementView busAndInventoryView;
    static List<Bus> busList;

    private BusAndInventoryManagementView() {
    }

    public static BusAndInventoryManagementView getInstance() {
        if (busAndInventoryView == null) busAndInventoryView = new BusAndInventoryManagementView();
        return busAndInventoryView;
    }

    @Override
    public void view() throws SQLException {
        while (true) {
            String[] choices = {"⭐ ADD NEW BUS (VEHICLE REGISTRATION)", "👤 DRIVER MANAGEMENT", "🔎 VIEW ALL REGISTERED BUSES", "⚙️ UPDATE BUS DETAILS (AMENITIES, SEATS, ETC.)", "🛑 DEACTIVATE OR BLOCK BUS (MAINTENANCE)", "⬅\uFE0F BACK"};
            int choice = InputUtil.getMenuChoice("\uD83D\uDE8D BUS & INVENTORY MANAGEMENT", choices);
            switch (choice) {
                case 1:
                    ServiceLocator.getInstance().getAddBusView().view();
                    break;
                case 2:
                    ServiceLocator.getInstance().getDriverView().view();
                    break;
                case 3:
                    ServiceLocator.getInstance().getBusListView().view();
                    break;
                case 4:
                case 5:
                case 6:
                    return;
            }
        }
    }

    static {
        long userId = Long.parseLong(PropertyFileHandler.getProperty("userId"));
        try {
            busList = BusController.getAllBus(userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
