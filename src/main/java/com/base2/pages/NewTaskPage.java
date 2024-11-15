package com.base2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewTaskPage {

    private WebDriverWait wait;

    public NewTaskPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "category_id")
    @CacheLookup
    private WebElement categoryDropdown;

    @FindBy(name = "summary")
    @CacheLookup
    private WebElement summaryField;

    @FindBy(name = "description")
    @CacheLookup
    private WebElement descriptionField;

    @FindBy(xpath = "//span[normalize-space()='Criar Tarefa']")
    @CacheLookup
    public WebElement createTaskButton;

    @FindBy(xpath = "//form//input[@value='Criar Nova Tarefa']")
    @CacheLookup
    private WebElement submitButton;

    @FindBy(xpath = "//td[@class='column-summary']")
    @CacheLookup
    private WebElement taskTitle;

    @FindBy(xpath = "(//p[@class='bold bigger-110'])[1]")
    @CacheLookup
    private WebElement sucesseMessage;

    public void enterTaskTitle(String title) {
        wait.until(ExpectedConditions.visibilityOf(summaryField));
        summaryField.sendKeys(title);
    }

    public void enterTaskDescription(String description) {
        wait.until(ExpectedConditions.visibilityOf(descriptionField));
        descriptionField.sendKeys(description);
    }

    public void selectTaskCategory(String category) {
        wait.until(ExpectedConditions.visibilityOf(categoryDropdown));
        Select dropdown = new Select(categoryDropdown);
        dropdown.selectByVisibleText(category);
    }

    public void clickCreateTaskButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();

    }

    public void createTaskButton() {
        wait.until(ExpectedConditions.elementToBeClickable(createTaskButton));
        createTaskButton.click();
    }

    public boolean doesTaskTitleContain(String phrase) {
        wait.until(ExpectedConditions.visibilityOf(taskTitle));
        return taskTitle.getText().contains(phrase);
    }

    public String getTaskMessage() {
        wait.until(ExpectedConditions.visibilityOf(sucesseMessage));
        return sucesseMessage.getText();
    }

}