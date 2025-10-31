package util.Validator;

public class Validator {

    public static boolean isNotNullOrEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isValidInteger(String input) {
        try {
            Integer.parseInt(input.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
