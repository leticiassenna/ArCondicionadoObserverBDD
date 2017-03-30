package br.ifes.leticia.ArCondicionadoObserverBDD;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;



public class ArCondicionado implements Observer{
    int mediaPessoas;
    int tempCalc, tempExterna;
    
    public int TEMP_TO_ALERT = 25;
    HashMap<Integer, Sensormeter> listaSensores = new  HashMap<Integer, Sensormeter>();
    
    
    public void update(Observable obs, Object obj) {
        
        Sensormeter sensor = (Sensormeter) obs;
                
        listaSensores.put(sensor.getCodSensor(), sensor);
        
        if(listaSensores.size() == 3){
            this.TEMP_TO_ALERT = this.TEMP_TO_ALERT + media_sensores(listaSensores.get(1), listaSensores.get(2), 
                    listaSensores.get(3));
            System.out.println(TEMP_TO_ALERT + " graus. Ideal: 25 graus");
            
            if(TEMP_TO_ALERT > 25){
            	this.tempCalc = this.TEMP_TO_ALERT;
                System.out.println("Temperatura normalizando");
                this.TEMP_TO_ALERT = this.TEMP_TO_ALERT - mediaPessoas;
                System.out.println("Normalizada com Sucesso!");
            }
            else {
                System.out.println("Nenhuma mudanca");
            }
        }
        else{
            System.out.println("Esperando outros sensores");
        }
        
    }
    
    public int media_sensores(Sensormeter sensor1, Sensormeter sensor2, Sensormeter sensor3){
        this.mediaPessoas = (int) Math.round((sensor1.getCurrentNumPessoas() + sensor2.getCurrentNumPessoas() 
                + sensor3.getCurrentNumPessoas())/3);
        /* COMETARIO REFERENCE AO ACERTO DO CALCULO PARA O VALOR DA TEMPERATURA 
        System.out.println((sensor1.getCurrentNumPessoas() + sensor2.getCurrentNumPessoas() 
        + sensor3.getCurrentNumPessoas())%3);
        double abc = (2.0+5.0+7.0)/3.0;
        int teste = (int) Math.round(4.6);
        System.out.println("OMG "+teste);*/
        
        if(mediaPessoas<=0){
            return 0;
        }
        else{
            return mediaPessoas;
        }
    }
	
    
}
