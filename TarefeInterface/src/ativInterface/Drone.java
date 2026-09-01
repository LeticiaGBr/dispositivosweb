package ativInterface;

public class Drone implements Motor{
	public String Modelo;

	public Drone(String modelo) {
		super();
		Modelo = modelo;
	}

	@Override
	public String ligar() {
		
		return "Drone " + Modelo +" Ligado";
	}

	@Override
	public String desligar() {
		return "Drone"+Modelo +" Desligado";
	}

	@Override
	public String operar() {
		
		return "Drone "+Modelo+" Operado";
	}
	
	
}
