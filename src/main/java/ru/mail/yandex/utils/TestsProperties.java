package ru.mail.yandex.utils;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class TestsProperties {
    private static Properties PROPERTIES;

    static{
        PROPERTIES = new Properties();
        URL props = ClassLoader.getSystemResource("tests.properties");
        try{
            PROPERTIES.load(props.openStream());
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return PROPERTIES.getProperty(key);
    }
}
