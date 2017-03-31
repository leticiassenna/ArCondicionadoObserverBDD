Feature: Controlar a temparatura interna da sala de aula

  Scenario Outline: Calcular temperatura interna da sala
    Given Eu quero controlar a temperatura interna da sala
    When Os sensores identificam a quantidade de pessoas na sala "<Sensor_Interno1>", "<Sensor_Interno2>", "<Sensor_Interno3>"
    And Recebo os valores dos sensores externos "<Sensor_Externo1>", "<Sensor_Externo2>", "<Sensor_Externo3>"
    Then Calcula a media de pessoas "<Media_Pessoas>" na sala e a media da temperatura externa "<Media_TempExterna>"
    And O ar condicionado calcula e normaliza a temperatura

    Examples: 
      | Sensor_Interno1 | Sensor_Interno2 | Sensor_Interno3 | Sensor_Externo1 | Sensor_Externo2 | Sensor_Externo3 | Media_Pessoas | Media_TempExterna |
      |               3 |               5 |               7 |              26 |              28 |              30 |             5 |                28 |
			|               4 |               6 |               5 |              27 |              26 |              31 |             5 |                28 |
			|               0 |               1 |               2 |               5 |               3 |               7 |             1 |                 5 |
			
