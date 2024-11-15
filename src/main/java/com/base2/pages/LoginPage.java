package com.base2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    @FindBy(name = "username")
    @CacheLookup
    private WebElement usernameField;

    @FindBy(name = "password")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(css = "input[type='submit']")
    @CacheLookup
    private WebElement loginButton;

    @FindBy(css = "input[type='submit'][value='Entrar']")
    @CacheLookup
    private WebElement enterButton;

    @FindBy(xpath = "//a[normalize-space()='Sair']")
    @CacheLookup
    public WebElement clickLogoutButton;

    @FindBy(xpath = "//span[normalize-space()='Criar Tarefa']")
    @CacheLookup
    public WebElement createTaskButton;

    @FindBy(xpath = "//i[@class='ace-icon fa fa-angle-down']")
    @CacheLookup
    public WebElement clickDropDownLogout;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void setPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clicklogoutButton() {
        clickLogoutButton.click();
    }

    public void clickdropDownLogout() {
        clickDropDownLogout.click();
    }

    public void clickEnterButton() {
        enterButton.click();
    }

    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLoginButton();
    }

    public void checkVisibilityOfCreateTaskButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(createTaskButton));
    }
}
