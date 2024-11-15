package com.base2.stepDefinitions.new_task;

import com.base2.pages.NewTaskPage;
import com.base2.utils.DriverManager;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NewTaskSteps {

    private WebDriver driver;
    private NewTaskPage taskPage;

    @Before
    public void setUp() {
        if (driver == null) {
            driver = DriverManager.getDriver();
        }
        taskPage = PageFactory.initElements(driver, NewTaskPage.class);
    }

    @Given("que o usuário está na página de criação de tarefa")
    public void queOUsuarioEstaNaPaginaDeCriacaoDeTarefa() {
        driver = DriverManager.getDriver();
        taskPage = new NewTaskPage(driver);
        driver.get(DriverManager.getBaseUrl());
    }

    @When("o usuário insere o título da tarefa {string}")
    public void oUsuarioInsereOTituloDaTarefa(String title) {
        taskPage.enterTaskTitle(title);
    }

    @When("o usuário insere a descrição {string}")
    public void oUsuarioInsereADescricao(String description) {
        taskPage.enterTaskDescription(description);
    }

    @When("o usuário seleciona a categoria {string}")
    public void oUsuarioSelecionaACategoria(String category) {
        taskPage.selectTaskCategory(category);
    }

    @When("o usuário clica no botão de criar tarefa")
    public void oUsuarioClicaNoBotaoDeCriarTarefa() {
        taskPage.createTaskButton();
    }

    @When("o usuário clica no botão de criar")
    public void oUsuarioClicaNoBotaoDeCriar() {
        taskPage.clickCreateTaskButton();
    }

    @Then("a tarefa {string} deve ser exibida na lista de tarefas")
    public void theTaskTitleShouldContain(String phrase) {
        taskPage = new NewTaskPage(driver);
        driver.get(DriverManager.getBase2Url());
        assertTrue(taskPage.doesTaskTitleContain(phrase));
    }

    @Then("deverá ser exibida uma mensagem de sucesso {string}")
    public void theTaskMessageShouldContain(String phrase) {
        assertTrue(taskPage.doesTaskMessageContain(phrase));
    }

}