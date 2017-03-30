package br.ifes.leticia.ArCondicionadoObserverBDD;


public class App {
	
	public static void main(String[] args){
        
        Sensormeter sensor1 = new Sensormeter();
        Sensormeter sensor2 = new Sensormeter();
        Sensormeter sensor3 = new Sensormeter();
        ArCondicionado arCondicionado = new ArCondicionado();
                
        sensor1.addObserver(arCondicionado);
        sensor1.setCurrentPessoas(4, 1);
        sensor2.addObserver(arCondicionado);
        sensor2.setCurrentPessoas(5, 2);
        sensor3.addObserver(arCondicionado);
        sensor3.setCurrentPessoas(9, 3);
        
    }

}
