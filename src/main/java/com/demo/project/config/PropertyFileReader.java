package com.demo.project.config;

import lombok.experimental.UtilityClass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public class PropertyFileReader {


    private static InputStream inputStream;
    private static Properties properties;


    public static String getProperty(String propertyFileName, String propertyName) {
        String property = "";

        properties = new Properties();

        inputStream = propertyFileAsStream(propertyFileName);
        loadProperties(propertyFileName);

        property = properties.getProperty(propertyName);
        closePropertyFile();

        return property;
    }

    private void closePropertyFile() {
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadProperties(String propertyFileName) {
        try {

            if (inputStream != null) {
                properties.load(inputStream);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("property file '" + propertyFileName + "' not found in the classpath");
        }
    }

    private InputStream propertyFileAsStream(String propertyFileName) {
        return PropertyFileReader.class.getClassLoader()
                .getResourceAsStream(propertyFileName);
    }


}
