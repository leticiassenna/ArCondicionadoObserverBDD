Feature: Controlar a temparatura interna da sala de aula

  Scenario: Calcular temperatura interna da sala
    Given Eu quero controlar a temperatura interna da sala
    When Os sensores identificam a quantidade de pessoas na sala 3, 5, 7
    And Calcula a media de pessoas 5 na sala
    Then O ar condicionado calcula e normaliza a temperatura 25

  Scenario: Calcular a temperatura externa da sala
    Given Eu quero controlar a temperatura externa da sala
    When Recebo os valores dos sensores internos 26, 28, 30
    Then Calcula a media dos valores dos sensores
    And O ar condicionado retorna o valor da temperatura externa 28
