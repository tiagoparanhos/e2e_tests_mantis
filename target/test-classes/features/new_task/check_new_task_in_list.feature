Feature: Verificar a listagem de tarefas

  Background: O usuário está logado no sistema
    Given que o usuário está na página de login do Mantis
    When o usuário entra com o username e senha válidos
    Then o usuário deve ser redirecionado para a página inicial do Mantis

    @checktaskinlist @critical
    Scenario Outline: Usuário verifica se a nova tarefa foi incluida na listagem com sucesso
    Given que o usuário está na página de criação de tarefa
    And o usuário clica no botão de criar tarefa
    When o usuário insere o título da tarefa "<título>"
    And o usuário insere a descrição "<descrição>"
    And o usuário seleciona a categoria "<categoria>"
    #And o usuário clica no botão de criar
    #And deverá ser exibida uma mensagem de sucesso "<mensagem>"
    Then a tarefa "<tarefa exibida>" deve ser exibida na lista de tarefas
    And o usuário deverá deslogar da página

    
    Examples:
    | título               | descrição                             | categoria                          | tarefa exibida  | mensagem |
    | Nova Tarefa de Teste | Descrição de teste para a nova tarefa | [Todos os Projetos] nova categoria | Tarefa de Teste | sucesso  |