Feature: Login no sistema Mantis

  @login @critical
  Scenario: Login com sucesso
    Given que o usuário está na página de login do Mantis
    When o usuário entra com o username e senha válidos
    And o usuário deve ser redirecionado para a página inicial do Mantis
    Then o usuário deverá deslogar da página