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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "category_id") // Campo de categoria
    @CacheLookup
    private WebElement categoryDropdown;

    @FindBy(name = "summary") // Campo de título da tarefa
    @CacheLookup
    private WebElement summaryField;

    @FindBy(name = "description") // Campo de descrição da tarefa
    @CacheLookup
    private WebElement descriptionField;

    @FindBy(xpath = "//span[normalize-space()='Criar Tarefa']")
    @CacheLookup
    public WebElement createTaskButton;

    @FindBy(xpath = "//form//input[@value='Criar Nova Tarefa']") // Botão para criar a tarefa
    @CacheLookup
    private WebElement submitButton;

    @FindBy(xpath = "//td[@class='column-summary']") // Element for task title
    @CacheLookup
    private WebElement taskTitle;

    @FindBy(xpath = "(//p[@class='bold bigger-110'])[1]")
    @CacheLookup
    private WebElement sucesseMessage;

    // Insere o título da tarefa
    public void enterTaskTitle(String title) {
        wait.until(ExpectedConditions.visibilityOf(summaryField));
        summaryField.sendKeys(title);
    }

    // Insere a descrição da tarefa
    public void enterTaskDescription(String description) {
        wait.until(ExpectedConditions.visibilityOf(descriptionField));
        descriptionField.sendKeys(description);
    }

    // Seleciona uma categoria da lista suspensa
    public void selectTaskCategory(String category) {
        wait.until(ExpectedConditions.visibilityOf(categoryDropdown));
        Select dropdown = new Select(categoryDropdown);
        dropdown.selectByVisibleText(category);
    }

    // Clica no botão para criar a tarefa
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

    public boolean doesTaskMessageContain(String phrase) {
        wait.until(ExpectedConditions.visibilityOf(sucesseMessage));
        return sucesseMessage.getText().contains(phrase);
    }
}