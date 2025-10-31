package util;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileHandler {

    private static final String FILE_NAME = "src/config/application.properties";
    private static Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            properties.load(fis);
        } catch (IOException e) {
            System.out.println("Properties file not found, creating new one...");
        }
    }

    public static void saveProperty(String key, String value) {
        properties.setProperty(key, value);
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {
            properties.store(fos, "User data");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void removeProperty() {
        properties.remove("userId");
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {
            properties.store(fos, "User data");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
