package view.owner;

import util.InputUtil;
import view.View;

public class BookingAndRevenueMonitoryView implements View {
    private static BookingAndRevenueMonitoryView bookingAndRevView;

    private BookingAndRevenueMonitoryView() {

    }

    public static BookingAndRevenueMonitoryView getInstance() {
        if (bookingAndRevView == null) {
            bookingAndRevView = new BookingAndRevenueMonitoryView();
        }
        return bookingAndRevView;
    }

    @Override
    public void view() {
        String[] choices = {"🟢 VIEW LIVE BOOKING STATUS (TODAY'S TRIPS)", "📈 VIEW TRIP HISTORY AND REVENUE REPORTS", "🧑‍🤝‍🧑 CHECK PASSENGER MANIFEST/LIST", "📢 VIEW PASSENGER COMPLAINTS AND FEEDBACK"};
        int choice = InputUtil.getMenuChoice("\uD83D\uDCCA BOOKING & REVENUE MONITORING", choices);
        switch (choice) {
            case 1:
            case 2:
            case 3:
            case 4:

        }
    }
}
