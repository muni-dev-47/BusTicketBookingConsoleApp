package view.owner;

import controllers.ownercontrollers.DriverController;
import models.Driver;
import util.InputUtil;
import util.PropertyFileHandler;
import view.View;

import java.sql.SQLException;
import java.util.*;

public class DriverListView implements View {
    private static DriverListView driverListView;

    private DriverListView() {
    }

    public static DriverListView getInstance() {
        if (driverListView == null) driverListView = new DriverListView();
        return driverListView;
    }

    @Override
    public void view() throws SQLException {
        long userId = Long.parseLong(PropertyFileHandler.getProperty("userId"));
        List<Driver> driverList = DriverController.getAllDriverList(userId);

        System.out.println("==========================================");
        System.out.printf("| %-10s | %-20s |%n", "Driver ID", "Driver Name");
        System.out.println("==========================================");

        Optional.ofNullable(driverList).orElse(Collections.emptyList()).stream().filter(Objects::nonNull).forEach(driver -> {
            System.out.printf("| %-10d | %-20s |%n", driver.getDriverId(), InputUtil.truncate(driver.getFullName(), 20));
        });

        System.out.println("==========================================");
    }
}
