package ativInterface;

public class Retroescavadeira implements Motor{
	private String Modelo;

	public Retroescavadeira(String modelo) {
		super();
		Modelo = modelo;
	}

	@Override
	public String ligar() {
		return "Retroescavadeiro do djanho chamada "+ Modelo
				+" ligada";
	}

	@Override
	public String desligar() {
		// TODO Auto-generated method stub
		return "Retroescavadeiro do djanho chamada "+ Modelo+" desligada";
	}

	@Override
	public String operar() {
		// TODO Auto-generated method stub
		return "Retroescavadeiro do djanho chamada "+ Modelo+" Operada";
	}
	
	
}
