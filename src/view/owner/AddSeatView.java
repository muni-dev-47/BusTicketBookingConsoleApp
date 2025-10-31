package view.owner;

import models.Seat;
import util.InputUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddSeatView {
    private static AddSeatView acv;

    private AddSeatView() {

    }

    public static AddSeatView getInstance() {
        if (acv == null) acv = new AddSeatView();
        return acv;
    }

    public List<Seat> getSeatInput() {
        Map<String, List<Seat>> seatsByDeck = new HashMap<>();

        System.out.println("\n=============================================");
        System.out.println("   🚌 START BUS SEAT LAYOUT DEFINITION");
        System.out.println("=============================================");

        String continueDeckInput = "Y";

        while (continueDeckInput.equalsIgnoreCase("Y")) {
            String deckTypeName = InputUtil.BusFormInputUtil.readSeatDeckType();

            if (seatsByDeck.containsKey(deckTypeName)) {
                System.out.println("⚠️ Warning: Layout for " + deckTypeName + " is already defined. Skipping.");
                continue;
            }

            System.out.println("\n--- Defining Seats for: " + deckTypeName + " ---");

            int maxRows = InputUtil.BusFormInputUtil.readSeatRow(20);
            int maxCols = InputUtil.BusFormInputUtil.readSeatColumn(6);
            List<Seat> currentDeckSeats = new ArrayList<>();
            char rowChar = 'A';

            for (int r = 1; r <= maxRows; r++) {

                System.out.println("\n⚙️ Defining Row " + rowChar + "...");

                for (int c = 1; c <= maxCols; c++) {
                    String seatLabel = "" + rowChar + c;

                    String confirm = InputUtil.readValidatedInput("Is Seat " + seatLabel + " present in the layout? (Y/N)", s -> s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("N"), "Please enter Y or N.");

                    if (confirm.equalsIgnoreCase("Y")) {
                        String seatTypeName = InputUtil.BusFormInputUtil.readSeatType();
                        Seat seat = new Seat(seatLabel, "N", seatTypeName, r, c, c == 1 || c == maxCols, deckTypeName);
                        if (c == 1 || c == maxCols) seat.setWindowSeat(true);
                        currentDeckSeats.add(seat);
                        System.out.println("✅ Seat " + seatLabel + " added as " + seatTypeName);
                    }
                }
                rowChar++;
            }

            seatsByDeck.put(deckTypeName, currentDeckSeats);

            if (seatsByDeck.containsKey("LOWER_DECK") && seatsByDeck.containsKey("UPPER_DECK")) {
                System.out.println("\n✅ Double-Decker Layout Complete. Stopping further deck definition.");
                break;
            }
            continueDeckInput = InputUtil.readValidatedInput("\nDo you want to define another deck (e.g., Upper Deck)? (Y/N)", s -> s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("N"), "Please enter Y or N.");
        }

        List<Seat> allSeats = new ArrayList<>();
        seatsByDeck.values().forEach(allSeats::addAll);

        System.out.println("\n=============================================");
        System.out.println("🚌 LAYOUT COMPLETE. Total Seats Defined: " + allSeats.size());
        System.out.println("=============================================");

        return allSeats;
    }
}
