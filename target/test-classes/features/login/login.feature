#language:pt

Funcionalidade: Login no sistema Mantis

  @login @critical
  Cenário:: Login com sucesso
    Dado que o usuário está na página de login do Mantis
    Quando o usuário entra com o username e senha válidos
    E o usuário deve ser redirecionado para a página inicial do Mantis
    Então o usuário deverá deslogar da página