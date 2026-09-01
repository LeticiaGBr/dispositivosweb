package Revisao;

public class Animal {
	private String Raca;
	
	public Animal (String Raca) {
		this.Raca = Raca;
	}
	public void emitirSom() {
		System.out.println("Som");
	}
	public String getRaca() {
		return Raca;
	}
	public void setRaca(String raca) {
		Raca = raca;
	}
	
}
