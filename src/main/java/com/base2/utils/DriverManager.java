package com.base2.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static final String CONFIG_PATH = "src/test/resources/config/config.properties";

    // Retorna o WebDriver associado à thread atual
    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            String driverPath = new File("drivers/chromedriver.exe").getAbsolutePath();
            System.setProperty("webdriver.chrome.driver", driverPath);
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driverThreadLocal.set(driver);
        }
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove(); // Remove a instância associada à thread
        }
    }

    public static String getBaseUrl() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(CONFIG_PATH));
            return properties.getProperty("base.url");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao carregar a URL base");
        }
    }

    public static String getBase2Url() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(CONFIG_PATH));
            return properties.getProperty("base2.url");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao carregar a URL base");
        }
    }
}
