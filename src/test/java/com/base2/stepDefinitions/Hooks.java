package com.base2.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.base2.utils.DriverManager;

public class Hooks {

    @Before
    public void setUp() {
        DriverManager.getDriver(); // Inicia o WebDriver para o cenário atual
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver(); // Encerra e limpa o WebDriver ao final do cenário
    }
}
