package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    static {
        try {
            prop = new Properties();

            // Provide full path or relative path to your file
            FileInputStream fis = new FileInputStream("resources/config.properties");

            // Load the properties
            prop.load(fis);

            // Close the stream
            fis.close();

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file", e);
        }
    }

    // Generic method to get value by key
    public static String get(String key) {
        return prop.getProperty(key);
    }
}