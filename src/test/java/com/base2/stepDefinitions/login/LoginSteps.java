package com.base2.stepDefinitions.login;

import com.base2.pages.LoginPage;
import com.base2.utils.ConfigUtils;
import com.base2.utils.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.E;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        if (driver == null) {
            driver = DriverManager.getDriver();
        }
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Dado("que o usuário está na página de login do Mantis")
    public void queOUsuarioEstaNaPaginaDeLoginDoMantis() {
        driver.get(DriverManager.getBaseUrl());
    }

    @Quando("o usuário entra com o username e senha válidos")
    public void oUsuarioEntraComOUsernameESenhaValidos() {
        String username = ConfigUtils.getProperty("username");
        String password = ConfigUtils.getProperty("password");
        loginPage.setUsername(username);
        loginPage.clickLoginButton();
        loginPage.setPassword(password);
        loginPage.clickEnterButton();
    }

    @E("o usuário deve ser redirecionado para a página inicial do Mantis")
    public void oUsuarioDeveVerOTextoNaPagina() {
        loginPage.checkVisibilityOfCreateTaskButton();
    }

    @Então("o usuário deverá deslogar da página")
    public void oUsuarioDeveraDeslogardaPagina() {
        loginPage.clickdropDownLogout();
        loginPage.clicklogoutButton();
    }

}