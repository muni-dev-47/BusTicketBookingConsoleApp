package util;

import models.RouteStop;
import repository.querys.ownerQuerys.BusType;
import repository.querys.ownerQuerys.DeckType;
import repository.querys.ownerQuerys.SeatType;
import util.Validator.BusFormValidator;
import util.Validator.RegistrationFormValidator;
import util.Validator.Validator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public final class InputUtil {

    private InputUtil() {

    }

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String readValidatedInput(String prompt, ValidatorFunction validator, String errorMessage) {
        String input;
        while (true) {
            System.out.print(prompt + ": ");
            input = SCANNER.nextLine().trim();
            if (input.isEmpty()) continue;
            if (validator.validate(input)) {
                return input.trim();
            } else {
                System.out.println("❌ " + errorMessage);
            }
        }
    }

    public static Scanner getScanner() {
        return SCANNER;
    }

    public static int readValidatedInteger(String prompt, Predicate<Integer> validator, String errorMessage) {

        while (true) {
            System.out.print(prompt + ": ");
            String input = SCANNER.nextLine().trim();

            try {
                int value = Integer.parseInt(input);

                if (validator.test(value)) {
                    return value;
                } else {
                    System.out.println(errorMessage);
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a valid whole number.");
            }
        }
    }

    public static double readValidatedDouble(String prompt, Predicate<Double> validator, String errorMessage) {

        while (true) {
            System.out.print(prompt + ": ");
            String input = SCANNER.nextLine().trim();

            try {
                double value = Integer.parseInt(input);

                if (validator.test(value)) {
                    return value;
                } else {
                    System.out.println(errorMessage);
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a valid whole number.");
            }
        }
    }

    public static int getMenuChoice(String title, String[] menuOptions) {

        String divider = "=".repeat(title.length() + 8);

        System.out.println("\n" + divider);
        System.out.println("    " + title.toUpperCase() + "    ");
        System.out.println(divider);

        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println((i + 1) + ". " + menuOptions[i]);
        }
        System.out.println(divider);

        int maxChoice = menuOptions.length;

        return readMenuChoice(maxChoice);
    }

    private static int readMenuChoice(int maxChoice) {
        String prompt = "Enter your choice (1 to " + maxChoice + ")";

        String choiceInput = readValidatedInput(prompt, Validator::isValidInteger, "Invalid input. Please enter a number.");

        try {
            int choice = Integer.parseInt(choiceInput);

            if (choice >= 1 && choice <= maxChoice) {
                return choice;
            } else {
                System.out.println("❌ Invalid choice. Please enter a number between 1 and " + maxChoice + ".");
                return readMenuChoice(maxChoice);
            }
        } catch (NumberFormatException e) {
            return readMenuChoice(maxChoice);
        }
    }


    public static class UserFormInputUtil {

        public static String readName() {
            return readValidatedInput("Enter Full Name", RegistrationFormValidator::isValidName, "Invalid name. Must be 3-50 letters and spaces.");
        }

        public static String readMobileNumber() {
            return readValidatedInput("Enter Mobile Number (10 digits)", RegistrationFormValidator::isValidMobileNumber, "Invalid mobile number. Must be 10 digits starting with 6, 7, 8, or 9.");
        }

        public static String readPassword() {
            System.out.println("Password must be at least 8 chars, incl. Upper/Lower/Digit/Special.");
            return readValidatedInput("Enter Password", RegistrationFormValidator::isValidPassword, "Password policy violation. Please check the requirements.");
        }

        public static String readEmail() {
            return readValidatedInput("Enter Email Address", RegistrationFormValidator::isValidEmail, "Invalid email format.");
        }

        public static int readAge() {
            String ageInput = readValidatedInput("Enter Age (1-100)", RegistrationFormValidator::isValidInteger, "Invalid input. Age must be a number.");

            int age = Integer.parseInt(ageInput);
            if (RegistrationFormValidator.isValidAge(age)) {
                return age;
            } else {
                System.out.println("❌ Age must be between 1 and 100.");
                return readAge();
            }
        }

        public static String readGender() {
            String genderInput = readValidatedInput("Enter Gender (M/F/O)", RegistrationFormValidator::isValidGender, "Invalid gender. Please enter M (Male), F (Female), or O (Other).");
            return genderInput.toUpperCase();
        }
    }


    public static class OwnerFormInputUtil extends UserFormInputUtil {
        public static String readGSTNumber() {
            return InputUtil.readValidatedInput("Enter Company GST Number (15 digits/chars)", RegistrationFormValidator::isValidGstNumber, "Invalid GST Number format. Must be 15 alphanumeric characters (e.g., 29ABCDE1234F1Z5).");
        }

        public static String getCompanyName() {
            return InputUtil.readValidatedInput("Enter Company Name (min 3 characters)", RegistrationFormValidator::isValidName, "❌ Invalid Company Name format. Name must contain only letters and spaces, and be at least 3 characters long.");
        }

        public static String getCity(String prompt) {
            return InputUtil.readValidatedInput(prompt, RegistrationFormValidator::isValidName, "❌ Invalid City Name format. City must contain only letters and spaces, and be at least 3 characters long.");
        }
    }


    public static class BusFormInputUtil {

        public static double readMinTurnaroundTimeHours() {

            String prompt = "⏳ Enter Minimum Turnaround Time (in Hours, e.g., 3.5)";

            Predicate<Double> validator = hours -> hours >= 1.0 && hours <= 24.0;

            String errorMessage = "❌ Invalid Time. Turnaround Time must be between 1.0 and 24.0 hours (e.g., 3.0 or 4.5).";

            return InputUtil.readValidatedDouble(prompt, validator, errorMessage);
        }

        public static String readRegistrationNumber() {

            return readValidatedInput("Enter Bus Registration Number (e.g., TN01AA0001)", BusFormValidator::isValidRegistrationNumber, "Invalid registration number format (e.g., TN01AA0001).");
        }

        public static String readBusType() {
            System.out.println("\n--- 🚌 AVAILABLE BUS TYPES ---");
            BusType[] types = BusType.values();
            for (int i = 0; i < types.length; i++) {
                System.out.printf("  %d. (%s)\n", (i + 1), types[i].name());
            }
            return readValidatedBusTypeChoice("\n✅ Select Bus Type by number (1 to " + types.length + ")", types.length, types);
        }

        public static String readBusName() {

            return readValidatedInput("Enter Bus Nickname/Name (e.g., 'King of the Road', min 3 characters)", RegistrationFormValidator::isValidName, "❌ Invalid Bus Name format. Name must contain only letters, numbers, and spaces (min 3 chars).");
        }

        public static String readAmenities() {
            StringBuilder amenitiesList = new StringBuilder();
            printHeading("\uD83D\uDE8C  Bus Amenities Setup");
            Function<String, Boolean> readYesNo = (amenityName) -> {
                while (true) {
                    System.out.print("👉 Does the bus have " + amenityName + "? (Y/N): ");
                    String input = SCANNER.nextLine();

                    if (BusFormValidator.isValidYesNo(input)) {
                        return input.trim().equalsIgnoreCase("Y");
                    } else {
                        System.out.println("❌ Invalid input. Please enter Y or N.\n");
                    }
                }
            };

            if (readYesNo.apply("Wi-Fi")) {
                amenitiesList.append("Wi-Fi,");
            }
            if (readYesNo.apply("Charging Point")) {
                amenitiesList.append("Charging Point,");
            }
            if (readYesNo.apply("Water Bottle")) {
                amenitiesList.append("Water Bottle,");
            }
            if (readYesNo.apply("Blanket/Pillow")) {
                amenitiesList.append("Blanket/Pillow,");
            }
            if (readYesNo.apply("On-board Restroom")) {
                amenitiesList.append("Restroom,");
            }

            String result = amenitiesList.toString();
            if (result.endsWith(",")) {
                return result.substring(0, result.length() - 1);
            }
            return result;
        }

        public static int readSeatColumn(int maxColumns) {
            String prompt = "Enter Max Seats Per Row (e.g., 4 for 2+2)";
            return readValidatedInteger(prompt, value -> value >= 4 && value <= maxColumns, "❌ Invalid Column Number. Column must be between 4 and " + maxColumns + ".");
        }

        public static int readSeatRow(int maxRow) {
            String prompt = "Enter Maximum Seat Rows for this deck (e.g., 10)";
            return readValidatedInteger(prompt, value -> value >= 4 && value <= maxRow, "❌ Invalid Column Number. Column must be between 4 and " + maxRow + ".");
        }

        public static String readSeatDeckType() {

            System.out.println("\n--- ⚓ SEAT DECK TYPE ---");

            DeckType[] types = DeckType.values();
            for (int i = 0; i < types.length; i++) {
                System.out.printf("  %d.(%s)\n", (i + 1), types[i].name());
            }

            return readValidatedDeckChoice("\n✅ Select Deck Type by number (1 to " + types.length + ")", types.length, types);
        }

        public static String readSeatType() {
            System.out.println("\n--- ⚓ SEAT TYPE ---");
            SeatType[] types = SeatType.values();
            for (int i = 0; i < types.length; i++) {
                System.out.printf("  %d.(%s)\n", (i + 1), types[i].name());
            }

            return readValidatedSeatTypeChoice("\n✅ Select Seat Type by number (1 to " + types.length + ")", types.length, types);
        }

        private static String readValidatedDeckChoice(String prompt, int maxChoice, DeckType[] types) {
            String input;
            while (true) {
                System.out.print(prompt + ": ");
                input = SCANNER.nextLine().trim();

                try {
                    int choiceIndex = Integer.parseInt(input);
                    if (choiceIndex >= 1 && choiceIndex <= maxChoice) {
                        return types[choiceIndex - 1].name();
                    } else {
                        System.out.println("❌ Invalid selection. Please enter a number between 1 and " + maxChoice + ".");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ Invalid input. Please enter only the number corresponding to your choice.");
                }
            }
        }

        private static String readValidatedBusTypeChoice(String prompt, int maxChoice, BusType[] types) {
            String input;
            while (true) {
                System.out.print(prompt + ": ");
                input = SCANNER.nextLine().trim();

                try {
                    int choiceIndex = Integer.parseInt(input);
                    if (choiceIndex >= 1 && choiceIndex <= maxChoice) {
                        return types[choiceIndex - 1].name();
                    } else {
                        System.out.println("❌ Invalid selection. Please enter a number between 1 and " + maxChoice + ".");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ Invalid input. Please enter only the number corresponding to your choice.");
                }
            }
        }

        private static String readValidatedSeatTypeChoice(String prompt, int maxChoice, SeatType[] types) {
            String input;
            while (true) {
                System.out.print(prompt + ": ");
                input = SCANNER.nextLine().trim();

                try {
                    int choiceIndex = Integer.parseInt(input);
                    if (choiceIndex >= 1 && choiceIndex <= maxChoice) {
                        return types[choiceIndex - 1].name();
                    } else {
                        System.out.println("❌ Invalid selection. Please enter a number between 1 and " + maxChoice + ".");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ Invalid input. Please enter only the number corresponding to your choice.");
                }
            }
        }
    }


    public static class BookingFormInputUtil {

    }


    public static class DriverFormInputUtil {

    }


    public static class ScheduleFormInputUtil {

        public static String readOriginCity() {
            String prompt = "➡️ Enter Origin City (Starting City):";
            String errorMessage = "❌ Invalid City Name. Please enter a valid city name (letters and spaces only).";
            return InputUtil.readValidatedInput(prompt, city -> !city.trim().isEmpty() && city.trim().matches("[a-zA-Z\\s]+"), errorMessage);
        }

        public static String readDestinationCity(String originCity) {
            String prompt = "🏁 Enter Destination City (Ending City):";
            String errorMessage = "❌ Invalid Destination. Destination must be a valid city name and cannot be the same as the Origin City (" + originCity + ").";
            return InputUtil.readValidatedInput(prompt, destinationCity -> !destinationCity.trim().isEmpty() && destinationCity.trim().matches("[a-zA-Z\\s]+") && !destinationCity.trim().equalsIgnoreCase(originCity), errorMessage);
        }

        public static double readRouteBasePrice() {

            String prompt = "💰 Enter Route Base Price (in Rupees, e.g., 850.50)";

            Predicate<Double> validator = price -> price > 100.0 && price < 10000.0;

            String errorMessage = "❌ Invalid Price. The Base Price must be a positive number greater than ₹100 and less than ₹10000.";

            return InputUtil.readValidatedDouble(prompt, validator, errorMessage);
        }

        public static String readRouteName() {

            String prompt = "⭐ Enter Route Nickname/Name (e.g., 'South Express', min 3 characters)";
            String errorMessage = "❌ Invalid Route Name format. Name must contain only letters, numbers, and spaces (min 3 chars).";

            return InputUtil.readValidatedInput(prompt, RegistrationFormValidator::isValidName, errorMessage);
        }

        public static int readDriverId() {

            String prompt = "👨‍✈️ Enter Driver ID to assign (e.g., 101)";

            Predicate<Integer> validator = id -> id > 0;

            String errorMessage = "❌ Invalid Driver ID. ID must be a positive number.";

            return InputUtil.readValidatedInteger(prompt, validator, errorMessage);
        }

        public static int readBusId() {

            String prompt = "🚌 Enter Bus ID to assign (e.g., 205)";

            Predicate<Integer> validator = id -> id > 0;

            String errorMessage = "❌ Invalid Bus ID. ID must be a positive number.";

            return InputUtil.readValidatedInteger(prompt, validator, errorMessage);
        }

        public static String readRouteStopCity() {

            String errorMessage = "❌ Invalid City Name. Please enter a valid city name (letters and spaces only).";

            return InputUtil.readValidatedInput("📍 Enter City Name for Stop:", city -> !city.trim().isEmpty() && city.trim().matches("[a-zA-Z\\s]+"), errorMessage);
        }

        public static String readValidTimeHHMM(String promptType, String city) {

            String prompt = "⏰ Enter " + promptType + " Time for " + city + " (Format: HH:MM, e.g., 23:30)";
            final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

            String errorMessage = "❌ Invalid Time Format. Please use the HH:MM format (24-hour clock, e.g., 09:15, 23:30).";

            return InputUtil.readValidatedInput(prompt, timeStr -> {
                try {
                    LocalTime.parse(timeStr.trim(), TIME_FORMATTER);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }, errorMessage);
        }

        public static LocalTime readTripTime(String type, String city) {

            String timeStr = readValidTimeHHMM(type, city);

            return LocalTime.parse(timeStr);
        }

        private static final double MIN_AVG_SPEED_KMH = 45.0;


        private static long calculateMinTravelMinutes(double distanceKm) {
            return (long) ((distanceKm / MIN_AVG_SPEED_KMH) * 60);
        }


        public static LocalTime readTripEndTime(LocalTime startTime, double routeDistanceKm, String destination) {

            long minTravelMinutes = calculateMinTravelMinutes(routeDistanceKm);

            long totalMinRequiredMinutes = minTravelMinutes + 60;

            while (true) {
                LocalTime endTime = readTripTime("Ending", destination);
                long actualDurationMinutes;
                if (endTime.isBefore(startTime)) {
                    long firstPart = ChronoUnit.MINUTES.between(startTime, LocalTime.MAX) + 1;
                    long secondPart = ChronoUnit.MINUTES.between(LocalTime.MIN, endTime);
                    actualDurationMinutes = firstPart + secondPart;
                } else {
                    actualDurationMinutes = ChronoUnit.MINUTES.between(startTime, endTime);
                }

                if (actualDurationMinutes >= totalMinRequiredMinutes) {
                    return endTime;
                } else {
                    System.out.printf("❌ Invalid End Time. For %.1f km, minimum travel time is %d minutes (%.2f hours). You set a duration of %d minutes. Please enter a later time.\n", routeDistanceKm, totalMinRequiredMinutes, totalMinRequiredMinutes / 60.0, actualDurationMinutes);
                }
            }
        }

        public static String readStopLocation(String cityName) {

            String errorMessage = "❌ Invalid Location. Please enter the specific boarding/dropping point (min 5 characters, avoid special symbols).";

            return InputUtil.readValidatedInput("🗺️ Enter Boarding/Dropping Point in " + cityName + " (e.g., Central Bus Stand, Toll Plaza):", location -> location.trim().length() >= 5 && location.trim().matches("^[a-zA-Z0-9\\s,-]+$"), errorMessage);
        }


        public static LocalDate readValidDateYYYYMMDD(String promptType) {

            String prompt = "📅 Enter " + promptType + " Date (Format: YYYY-MM-DD, e.g., 2025-12-31)";
            final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            String errorMessage = "❌ Invalid Date Format. Please use the YYYY-MM-DD format (e.g., 2025-10-30).";

            String dateStr = InputUtil.readValidatedInput(prompt, dateStr1 -> {
                try {
                    LocalDate.parse(dateStr1.trim(), DATE_FORMATTER);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }, errorMessage);

            return LocalDate.parse(dateStr, DATE_FORMATTER);
        }

        public static double getTotalDistance(List<RouteStop> routeStops) {
            double totalDistance = 0;
            for (RouteStop routeStop : routeStops) {
                totalDistance += routeStop.getDistanceFromOriginKm();
            }
            return totalDistance;
        }
    }

    public static void printHeading(String title) {
        String divider = "=".repeat(title.length() + 8);
        System.out.println("\n" + divider);
        System.out.println("    " + title.toUpperCase() + "    ");
        System.out.println(divider);
    }


    public static String truncate(String text, int maxLength) {
        if (text == null) return "";
        return text.length() > maxLength ? text.substring(0, maxLength - 3) + "..." : text;
    }

    @FunctionalInterface
    public interface ValidatorFunction {
        boolean validate(String input);
    }
}