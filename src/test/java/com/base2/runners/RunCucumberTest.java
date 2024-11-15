package com.base2.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", // Caminho para os arquivos de feature
        glue = "com.base2.stepDefinitions", // Caminho para as definições de steps
        plugin = { "pretty", "html:target/cucumber-reports" } // Plugins para gerar relatórios
)
public class RunCucumberTest {
    // Classe de execução, não precisa de métodos, pois o JUnit executará os testes
    // automaticamente
}