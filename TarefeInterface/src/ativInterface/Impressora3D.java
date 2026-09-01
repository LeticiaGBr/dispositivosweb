package ativInterface;

public class Impressora3D implements Motor{
	public String modelo;

	public Impressora3D(String modelo) {
		super();
		this.modelo = modelo;
	}

	@Override
	public String ligar() {
		// TODO Auto-generated method stub
		return "A impressora"+modelo + " considerada o djanho pelos técnicos em informatica foi Ligada";
	}

	@Override
	public String desligar() {
		// TODO Auto-generated method stub
		return "A impressora"+modelo + " considerada o djanho pelos técnicos em informatica foi  desligada";
	}

	@Override
	public String operar() {
		// TODO Auto-generated method stub
		return "A impressora "+modelo + " considerada o djanho pelos técnicos em informatica foi Operada";
	}
	
	

}
