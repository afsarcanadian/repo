package utils;

import Constant.Constant;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties properties;
    static FileInputStream file;

    public static Properties configReader(String path){
        try {
            file = new FileInputStream(path);
            properties = new Properties();
            try {
                properties.load(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return properties;
    }
    public static String getPropertyValue(String name){
        String value = properties.getProperty(name);
        return value;
    }



}
