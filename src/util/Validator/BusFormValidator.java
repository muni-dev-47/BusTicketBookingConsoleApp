package util.Validator;

public class BusFormValidator extends Validator {
    public static boolean isValidRegistrationNumber(String regNo) {
        if (!isNotNullOrEmpty(regNo)) return false;
        String sanitizedRegNo = regNo.replaceAll("[\\s\\-]", "").toUpperCase();

        return sanitizedRegNo.matches("^[A-Z]{2}\\d{2}[A-Z]{2}\\d{4}$");
    }


    public static boolean isValidBusType(String type) {
        if (!isNotNullOrEmpty(type)) return false;

        String normalizedType = type.trim().toUpperCase();

        return normalizedType.equals("AC SLEEPER") || normalizedType.equals("NON-AC SEATER") || normalizedType.equals("AC SEMI-SLEEPER") || normalizedType.equals("VOLVO MULTI-AXLE") || normalizedType.equals("AC SEATER") || normalizedType.equals("NON-AC SLEEPER") || normalizedType.equals("NON-AC SEMI-SLEEPER") || normalizedType.equals("AC SEATER CUM SLEEPER") ||
                normalizedType.equals("NON-AC SEATER CUM SLEEPER");
    }


    public static boolean isValidSeatRange(int seats) {
        return seats >= 20 && seats <= 60;
    }

    public static boolean isValidYesNo(String input) {
        if (!isNotNullOrEmpty(input)) return false;
        String normalized = input.trim().toUpperCase();
        return normalized.equals("Y") || normalized.equals("N");
    }


}
