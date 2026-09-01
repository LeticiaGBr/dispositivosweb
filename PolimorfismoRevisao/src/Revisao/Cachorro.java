package Revisao;

public class Cachorro extends Animal {

	public Cachorro(String Raca) {
		super(Raca);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void emitirSom() {
		// TODO Auto-generated method stub
		System.out.println("latido");
	}
	public void abanarabo() {
		System.out.println("Abanado o rabo do cachorro");
	}

}
