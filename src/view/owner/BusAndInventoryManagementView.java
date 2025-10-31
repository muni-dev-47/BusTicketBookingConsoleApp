package view.owner;

import config.ServiceLocator;
import util.InputUtil;
import view.View;

public class BusAndInventoryManagementView implements View {
    private static BusAndInventoryManagementView busAndInventoryView;

    private BusAndInventoryManagementView() {
    }

    public static BusAndInventoryManagementView getInstance() {
        if (busAndInventoryView == null) busAndInventoryView = new BusAndInventoryManagementView();
        return busAndInventoryView;
    }

    @Override
    public void view() {
        while (true) {
            String[] choices = {"⭐ ADD NEW BUS (VEHICLE REGISTRATION)", "🔎 VIEW ALL REGISTERED BUSES", "⚙️ UPDATE BUS DETAILS (AMENITIES, SEATS, ETC.)", "🛑 DEACTIVATE OR BLOCK BUS (MAINTENANCE)", "⬅\uFE0F BACK"};
            int choice = InputUtil.getMenuChoice("\uD83D\uDE8D BUS & INVENTORY MANAGEMENT", choices);
            switch (choice) {
                case 1:
                    ServiceLocator.getInstance().getAddBusView().view();
                case 2:
                case 3:
                case 4:
                case 5:
                    return;
            }
        }
    }
}
