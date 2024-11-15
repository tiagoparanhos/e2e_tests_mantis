#language:pt

Funcionalidade: Criar nova tarefa no Mantis

  Contexto: O usuário está logado no sistema
    Dado que o usuário está na página de login do Mantis
    Quando o usuário entra com o username e senha válidos
    Então o usuário deve ser redirecionado para a página inicial do Mantis

    @newtasktest @critical
    Esquema do Cenário: Usuário cria uma nova tarefa com sucesso
    Dado que o usuário está na página de criação de tarefa
    Quando o usuário clica no botão de criar tarefa
    E o usuário insere o título da tarefa "<título>"
    E o usuário insere a descrição "<descrição>"
    E o usuário seleciona a categoria "<categoria>"
    E o usuário clica no botão de criar
    Então deverá ser exibida uma mensagem de sucesso "<mensagem>"

    Exemplos:
    | título               | descrição                             | categoria                          | tarefa exibida  | mensagem |
    | Nova Tarefa de Teste | Descrição de teste para a nova tarefa | [Todos os Projetos] nova categoria | Tarefa de Teste | sucesso  |