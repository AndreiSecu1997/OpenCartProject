package dataProviders;

import enums.DriverType;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestDataFileReaders {
    private static Properties properties;

    public TestDataFileReaders() {
        properties = new Properties();
        String propertyFilePath = "C:\\Users\\asecu\\IdeaProjects\\OpenCartProject\\src\\test\\testResources\\test.properties";

        try {
            properties.load(new FileReader(propertyFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException("The property file was not found on the following address: " + propertyFilePath);
        }
    }

    public static String getPageURL(String pageName) {
        try {
            return properties.getProperty(pageName + "URL");
        } catch (Exception e) {
            throw new RuntimeException("The url for speciefied page is not found in the property file.");
        }
    }

    public static String getEmail(String userOrder){
        try {
            return properties.getProperty(userOrder);
        }catch (Exception e){
            throw new RuntimeException("No such email in the properties file");
        }
    }

    public static String getPassword(String userOrder){
        try {
            return properties.getProperty(userOrder);
        }catch (Exception e){
            throw new RuntimeException("No such password in the properties file");
        }
    }

    public static DriverType getBrowser() {
        try {
            String driverName = properties.getProperty("browser").toUpperCase();
            switch (driverName) {
                case "CHROME":
                    return DriverType.CHROME;
                case "FIREFOX":
                    return DriverType.FIREFOX;
                default:
                    return DriverType.CHROME;
            }
        }catch (Exception e){
            throw new RuntimeException("The browser property is not present in the properties file");
        }
    }
}
