package br.ifes.leticia.ArCondicionadoObserverBDD;

import java.util.Observable;

public class Sensormeter extends Observable{
    private int currentNumPessoas = 0;
    private int codSensor;
    
    public void setCurrentPessoas(int numPessoas, int codSensor){
        this.currentNumPessoas = numPessoas;
        this.codSensor = codSensor;
        setChanged();
        notifyObservers();
    }
    
    public int getCurrentNumPessoas(){
        return currentNumPessoas;
    }
    
    public int getCodSensor(){
        return codSensor;
    }

}
