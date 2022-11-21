package helpers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LanguageProperties {
    private static Properties properties;
    private static String currentLanguage;
    static FileReader reader;

    public static void initProperties() {
        try {
            reader = new FileReader(String.format("src/test/java/properties/%s.properties", getCurrentLanguage()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        properties = new Properties();
        try {
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String name) {
        initProperties();
        System.out.println(properties.getProperty(name));
        return properties.getProperty(name);
    }

    public static String getCurrentLanguage() {
        return currentLanguage;
    }

    public static void setCurrentLanguage(String selectedLanguage) {   //////////                     ZAMIENIC NA ENUM
        currentLanguage = selectedLanguage;
    }
}