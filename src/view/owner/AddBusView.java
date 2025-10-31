package view.owner;

import config.ServiceLocator;
import controllers.ownercontrollers.BusRegistrationController;
import models.Bus;
import models.Seat;
import util.InputUtil;
import util.PropertyFileHandler;
import view.View;

import java.sql.SQLException;
import java.util.List;

public class AddBusView implements View {

    private static AddBusView addbusview;
    private static final AddSeatView asv = ServiceLocator.getInstance().getAddSeatView();

    private AddBusView() {

    }

    public static AddBusView getInstance() {
        if (addbusview == null) addbusview = new AddBusView();
        return addbusview;
    }

    @Override
    public void view() {
        try {
            String busNo = InputUtil.BusFormInputUtil.readRegistrationNumber();
            if (!BusRegistrationController.isBusNumberAvailable(busNo)) {
                System.out.println("❌ Error: This Bus Registration Number (" + busNo + ") is already registered in our system. \n" + "Each bus must have a unique RC Number. \n" + "Please verify the number or contact support if you believe this is an error.");
                return;
            }
            String busName = InputUtil.BusFormInputUtil.readBusName();
            String busType = InputUtil.BusFormInputUtil.readBusType();
            String amenities = InputUtil.BusFormInputUtil.readAmenities();
            double minTurnaroundTimeHours = InputUtil.BusFormInputUtil.readMinTurnaroundTimeHours();
            List<Seat> seats = asv.getSeatInput();
            int totalSeats = seats.size();
            long userId = Long.parseLong(PropertyFileHandler.getProperty("userId"));
            long busId;
            if ((busId = BusRegistrationController.handleRegisterNewBus(new Bus(amenities, busType, busName, busNo, totalSeats, userId, minTurnaroundTimeHours), seats)) != 0) {
                System.out.println("\n=======================================================");
                System.out.println("🎉 SUCCESS! NEW BUS REGISTERED!");
                System.out.println("🚌 Registered Bus ID: " + busId);
                System.out.println("=======================================================");
                System.out.println("Next Step: Use this Bus ID to create new trips and set fares.");

            } else {
                System.out.println("\n❌ ERROR: Bus registration failed. Please check input details or contact system administrator.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
