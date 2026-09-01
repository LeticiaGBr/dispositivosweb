package Jogo;

public class Jogo {
public static void main(String[] args) {
	Guerreiro kaelen = new Guerreiro();
	Mago fada = new Mago();
	Arqueiro criz = new Arqueiro();
	
	
	Personagem[] personagens = new Personagem[3];
	personagens[0] = kaelen;
	personagens[1]= fada;
	personagens[2]=criz;
	
	for (int i = 0; i < personagens.length; i++) {
		personagens[i].Atacar("Fodão ");
	}
	 
}
}
