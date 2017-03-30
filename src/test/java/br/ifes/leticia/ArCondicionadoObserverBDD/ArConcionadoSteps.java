package br.ifes.leticia.ArCondicionadoObserverBDD;

import static org.junit.Assert.assertEquals;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ArConcionadoSteps {

	Sensormeter sensor1 = new Sensormeter();
    Sensormeter sensor2 = new Sensormeter();
    Sensormeter sensor3 = new Sensormeter();
    ArCondicionado arCondicionado;
	
	//Cenario interno
	@Given("^Eu quero controlar a temperatura interna da sala$")
	public void eu_quero_controlar_a_temperatura_interna_da_sala() throws Throwable {
    	arCondicionado = new ArCondicionado();
	}

	@When("^Os sensores identificam a quantidade de pessoas na sala (\\d+), (\\d+), (\\d+)$")
	public void os_sensores_identificam_a_quantidade_de_pessoas_na_sala(int arg1, int arg2, int arg3) throws Throwable {
		sensor1.addObserver(arCondicionado);
        sensor1.setCurrentPessoas(arg1, 1);
        sensor2.addObserver(arCondicionado);
        sensor2.setCurrentPessoas(arg2, 2);
        sensor3.addObserver(arCondicionado);
        sensor3.setCurrentPessoas(arg3, 3);
	}

	@When("^Calcula a media de pessoas (\\d+) na sala$")
	public void calcula_a_media_de_pessoas_na_sala(int arg1) throws Throwable {
		assertEquals(arg1, arCondicionado.mediaPessoas);
	}

	@Then("^O ar condicionado calcula e normaliza a temperatura (\\d+)$")
	public void o_ar_condicionado_calcula_e_normaliza_a_temperatura(int arg1) throws Throwable {
	    assertEquals(arg1, arCondicionado.TEMP_TO_ALERT);
	}

	
	//Cenario externo
	@Given("^Eu quero controlar a temperatura externa da sala$")
	public void eu_quero_controlar_a_temperatura_externa_da_sala() throws Throwable {
	    
	}
	
	@When("^Recebo os valores dos sensores internos (\\d+), (\\d+), (\\d+)$")
	public void recebo_os_valores_dos_sensores_internos(int arg1, int arg2, int arg3) throws Throwable {
	    
	}

	@Then("^Calcula a media dos valores dos sensores$")
	public void calcula_a_media_dos_valores_dos_sensores() throws Throwable {
	    
	}

	@Then("^O ar condicionado retorna o valor da temperatura externa (\\d+)$")
	public void o_ar_condicionado_retorna_o_valor_da_temperatura_externa(int arg1) throws Throwable {
	    
	}
	
}
