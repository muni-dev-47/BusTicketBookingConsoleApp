package util.Validator;

import java.util.regex.Pattern;

public class RegistrationFormValidator extends Validator {


    private RegistrationFormValidator() {
    }

    public static boolean isValidName(String name) {
        if (!isNotNullOrEmpty(name)) return false;
        return name.length() >= 3 && name.matches("[a-zA-Z\\s]{3,50}");
    }

    public static boolean isValidMobileNumber(String mobile) {
        if (!isNotNullOrEmpty(mobile)) return false;
        return mobile.matches("[6-9]\\d{9}");
    }

    public static boolean isValidEmail(String email) {
        if (!isNotNullOrEmpty(email)) return false;
        return email.matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
    }

    public static boolean isValidPassword(String password) {
        if (!isNotNullOrEmpty(password)) return false;
        return password.length() >= 8 && password.matches(".*\\d.*") && password.matches(".*[a-z].*") && password.matches(".*[A-Z].*") && password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*");
    }

    public static boolean isValidAge(int age) {
        return age > 0 && age <= 100;
    }

    public static boolean isValidGender(String gender) {
        if (!isNotNullOrEmpty(gender)) return false;
        String normalized = gender.trim().toUpperCase();
        return normalized.equals("M") || normalized.equals("F") || normalized.equals("O");
    }

    public static boolean isValidGstNumber(String gstNumber) {

        if (gstNumber == null) {
            return false;
        }

        if (gstNumber.length() != 15) {
            return false;
        }
        String GSTIN_REGEX = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}[Z]{1}[0-9A-Z]{1}$";
        Pattern GSTIN_PATTERN = Pattern.compile(GSTIN_REGEX);

        return GSTIN_PATTERN.matcher(gstNumber.toUpperCase()).matches();
    }
}