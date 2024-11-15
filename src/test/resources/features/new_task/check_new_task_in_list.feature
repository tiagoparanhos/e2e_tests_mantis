  #language:pt

  Funcionalidade: Verificar a listagem de tarefas

  Contexto: O usuário está logado no sistema
    Dado que o usuário está na página de login do Mantis
    Quando o usuário entra com o username e senha válidos
    Então o usuário deve ser redirecionado para a página inicial do Mantis

 # Em um segundo momento nesta feature eu faria uma refatoração para focar no objetivo que é verificar a listagem
 # Eu criaria um metodo para o cadastro da tarefa ser feito via API e um step de uma linha com essa chamada
 # E na sequência verificar se a nova tarefa foi exibida na listagem, dessa forma ganharia agilidade na execução
 # Já que a outra feature de criar uma nova tarefa já valida pelo fluxo do front o cadastro não sendo necessário repetí-la

    @checktaskinlist @critical
    Esquema do Cenário: Usuário verifica se a nova tarefa foi incluida na listagem com sucesso
    Dado que o usuário está na página de criação de tarefa
    Quando o usuário clica no botão de criar tarefa
    E o usuário insere o título da tarefa "<título>"
    E o usuário insere a descrição "<descrição>"
    E o usuário seleciona a categoria "<categoria>"
    E o usuário clica no botão de criar
    E deverá ser exibida uma mensagem de sucesso "<mensagem>"
    Então a tarefa "<tarefa exibida>" deve ser exibida na lista de tarefas
    
    Exemplos:
    | título               | descrição                             | categoria                          | tarefa exibida  | mensagem |
    | Nova Tarefa de Teste | Descrição de teste para a nova tarefa | [Todos os Projetos] nova categoria | Tarefa de Teste | sucesso  |