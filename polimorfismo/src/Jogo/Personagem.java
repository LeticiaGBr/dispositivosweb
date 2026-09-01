package Jogo;

public class Personagem {
	//+  = public 
	// - = privado
	private int vida;
	
	
	public void Atacar() {
		System.out.print("Ataque");
	}
	public void Atacar(String tipo) {
		System.out.println("Personagem executou Ataque do tipo:"+tipo);
	}
}
