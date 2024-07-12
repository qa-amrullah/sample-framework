package com.automation.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("Configuration.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
