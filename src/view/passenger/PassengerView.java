package view.passenger;

import util.InputUtil;
import view.View;

public class PassengerView implements View {
    private static PassengerView pv;

    private PassengerView() {

    }

    public static PassengerView getInstance() {
        if (pv == null) {
            pv = new PassengerView();
        }
        return pv;
    }

    @Override
    public void view() {
        String[] choices = {"\uD83C\uDFAB TICKET BOOKING & SEARCH", "\uD83D\uDDC3\uFE0F BOOKING MANAGEMENT", "\uD83D\uDCDD FEEDBACK & SUPPORT", "⚙\uFE0F ACCOUNT & PROFILE"};
        while (true) {
            int choice = InputUtil.getMenuChoice("\uD83D\uDC64 PASSENGER BUS RESERVATION SYSTEM", choices);
            switch (choice) {
                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;
            }
        }
    }
}
