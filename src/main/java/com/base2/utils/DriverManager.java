package com.base2.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static final String CONFIG_PATH = "src/test/resources/config/config.properties";

    // Retorna o WebDriver associado à thread atual
    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            try {
                // Carrega as propriedades de configuração
                Properties properties = new Properties();
                properties.load(new FileInputStream(CONFIG_PATH));

                // Configura o caminho do WebDriver
                System.setProperty("webdriver.chrome.driver", properties.getProperty("driver.path"));

                // Cria uma nova instância do WebDriver para a thread atual
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();

                // Armazena o WebDriver na ThreadLocal
                driverThreadLocal.set(driver);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Falha ao carregar o arquivo de configuração");
            }
        }
        return driverThreadLocal.get();
    }

    // Finaliza o WebDriver e remove-o da ThreadLocal
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
