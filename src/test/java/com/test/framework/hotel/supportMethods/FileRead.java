package com.test.framework.hotel.supportMethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileRead {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileRead.class);


    public static FileInputStream getPropertiesFile() throws FileNotFoundException {
        String testProperties = System.getProperties().getProperty("test.properties", "chrome.properties");
        String filePath = "src/test/resources/" + testProperties;
        LOGGER.info("Using the properties file: ", testProperties);
        return new FileInputStream(new File(filePath));

    }

    public static Map<String, String> readProperties() throws IOException {

        Properties prop = new Properties();
        prop.load(getPropertiesFile());

        Map<String, String> properties = new HashMap<String, String>();

        Enumeration<Object> KeyValues = prop.keys();
        while (KeyValues.hasMoreElements()) {
            String key = (String) KeyValues.nextElement();
            String value = prop.getProperty(key);
            properties.put(key, System.getProperty(key, value));
        }

        return properties;
    }


}
