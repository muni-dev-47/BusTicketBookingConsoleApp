package view.owner;

import controllers.ownercontrollers.BusController;
import models.Bus;
import util.InputUtil;
import util.PropertyFileHandler;
import view.View;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BusListView implements View {
    private static BusListView busListView;

    private BusListView() {
    }

    public static BusListView getInstance() {
        if (busListView == null) busListView = new BusListView();
        return busListView;
    }

    @Override
    public void view() throws SQLException {
        List<Bus> busList = BusAndInventoryManagementView.busList;

        String line = "=".repeat(110);
        System.out.println(line);
        System.out.printf("| %-4s | %-15s | %-12s | %-10s | %-8s | %-6s | %-20s | %-8s |%n",
                "ID", "Name", "Reg No", "Type", "Status", "Seats", "Amenities", "TAT Hrs");
        System.out.println(line);

        Optional.ofNullable(busList)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .forEach(bus -> System.out.printf(
                        "| %-4d | %-15s | %-12s | %-10s | %-8s | %-6d | %-20s | %-8.1f |%n",
                        bus.getBusId(),
                        InputUtil.truncate(bus.getBusName(), 15),
                        bus.getRegistrationNumber(),
                        InputUtil.truncate(bus.getBusType(), 10),
                        InputUtil.truncate(bus.getStatus(), 8),
                        bus.getTotalSeats(),
                        InputUtil.truncate(bus.getAmenities(), 20),
                        bus.getMinTurnaroundTimeHours()
                ));

        System.out.println(line);

    }
}
