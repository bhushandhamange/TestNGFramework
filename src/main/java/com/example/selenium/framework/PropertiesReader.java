package com.example.selenium.framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static final Logger logger = LogManager.getLogger(PropertiesReader.class);
    private static Properties properties = new Properties();
    static {
        try (InputStream input = PropertiesReader.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                logger.error("Sorry, unable to find application.properties");
                throw new RuntimeException("Sorry, unable to find application.properties");
            }
            // Load the properties file
            logger.info("Loading the properties file");
            properties.load(input);
        } catch (IOException ex) {
            logger.error("Failed to load properties file", ex);
            ex.printStackTrace();
            throw new RuntimeException("Failed to load properties file", ex);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static int getIntProperty(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }

    public static boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(properties.getProperty(key));
    }
}
