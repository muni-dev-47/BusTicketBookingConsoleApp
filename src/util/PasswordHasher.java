package util;


import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

public class PasswordHasher {

    private static final int SALT_LENGTH = 16;
    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 256;

    public static String hashPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = generateSalt();

        byte[] hash = calculateHash(password, salt);

        String saltBase64 = Base64.getEncoder().encodeToString(salt);
        String hashBase64 = Base64.getEncoder().encodeToString(hash);

        return saltBase64 + ":" + hashBase64;
    }

    public static boolean verifyPassword(String password, String storedHash) throws NoSuchAlgorithmException, InvalidKeySpecException {

        String[] parts = storedHash.split(":");
        if (parts.length != 2) return false;

        byte[] salt = Base64.getDecoder().decode(parts[0]);
        byte[] originalHash = Base64.getDecoder().decode(parts[1]);

        byte[] testHash = calculateHash(password, salt);


        return Arrays.equals(originalHash, testHash);
    }

    private static byte[] generateSalt() {
        byte[] salt = new byte[SALT_LENGTH];
        new SecureRandom().nextBytes(salt);
        return salt;
    }

    private static byte[] calculateHash(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        return factory.generateSecret(spec).getEncoded();
    }
}
