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
    int sensorExt1, sensorExt2, sensorExt3; 
	
	//Cenario interno
	@Given("^Eu quero controlar a temperatura interna da sala$")
	public void eu_quero_controlar_a_temperatura_interna_da_sala() throws Throwable {
    	arCondicionado = new ArCondicionado();
	}
	
	@When("^Os sensores identificam a quantidade de pessoas na sala \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void os_sensores_identificam_a_quantidade_de_pessoas_na_sala(String arg1, String arg2, String arg3) throws Throwable {
		sensor1.addObserver(arCondicionado);
        sensor1.setCurrentPessoas(Integer.parseInt(arg1), 1);
        sensor2.addObserver(arCondicionado);
        sensor2.setCurrentPessoas(Integer.parseInt(arg2), 2);
        sensor3.addObserver(arCondicionado);
        sensor3.setCurrentPessoas(Integer.parseInt(arg3), 3);
	}

	@When("^Recebo os valores dos sensores externos \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void recebo_os_valores_dos_sensores_externos(String arg1, String arg2, String arg3) throws Throwable {
	    arCondicionado.media_temp_externa(Integer.parseInt(arg1), Integer.parseInt(arg2), Integer.parseInt(arg3));
	}

	@Then("^Calcula a media de pessoas \"([^\"]*)\" na sala e a media da temperatura externa \"([^\"]*)\"$")
	public void calcula_a_media_de_pessoas_na_sala_e_a_media_da_temperatura_externa(String arg1, String arg2) throws Throwable {
		assertEquals(Integer.parseInt(arg1), arCondicionado.mediaPessoas);
		assertEquals(Integer.parseInt(arg2), arCondicionado.tempExterna);
	}

	@Then("^O ar condicionado calcula e normaliza a temperatura$")
	public void o_ar_condicionado_calcula_e_normaliza_a_temperatura() throws Throwable {
		assertEquals(25, arCondicionado.TEMP_TO_ALERT);
	}
	
	
}
