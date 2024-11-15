# Execução do Projeto Local
Para rodar este projeto, siga os passos abaixo:

Instalar JDK 11 ou superior
Baixe e instale o JDK 11 ou superior em sua máquina. 

Instalar Maven
Baixe a versão mais recente do Maven. 

Instalar a IDE
Baixe e instale a IDE de sua preferência para rodar o projeto. No meu caso, uso o VSCode.

Clonar o Repositório
https://github.com/tiagoparanhos/mantis_e2e_test.git

# Parâmetros de Execução
Para passar parâmetros, use o prefixo -D seguido do nome do parâmetro. Exemplos:

Definir o ambiente de execução: 
Use -DENV para escolher o ambiente de testes, como homologação (HMG) ou estágio (STG). Para rodar no GitHub Actions, utilize -DENV=CHROME_HEADLESS ou -DENV=EDGE_HEADLESS.

mvn test -DBROWSER=chrome

Comandos para Execução
open target/cucumber-reports/cucumber-html-reports.html: Abre o relatório HTML gerado pelos testes Cucumber para análise visual dos resultados.

mvn test 
Executa os testes de forma padrão, rodando todos os cenários definidos no Cucumber.

mvn clean test
Limpa os artefatos gerados anteriormente e executa os testes novamente, garantindo que nenhum resíduo de execução anterior impacte os resultados.

mvn test -Dcucumber.filter.tags="@usesuatag"
Executa apenas os testes que possuem determinada tag, permitindo rodar um subconjunto específico de testes baseados em tags.

# Ferramentas Utilizadas
Java
JUnit
Maven
Selenium WebDriver
Cucumber (BDD)/Gherkin