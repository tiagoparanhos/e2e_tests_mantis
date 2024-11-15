package com.base2.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigUtils.class.getClassLoader()
                .getResourceAsStream("config/credentials.properties")) {
            if (input == null) {
                System.out.println("Desculpe, o arquivo de propriedades não foi encontrado.");
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
