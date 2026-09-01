package ativInterface;

public class Main {
public static void main(String[] args) {
	

	Motor[] M = new Motor[3];
					M[0] = new Retroescavadeira("Bolada");
					M[1] = new Impressora3D("djanho");
	
					M[2] = new Drone("Fodastico");
			for (int i = 0; i < M.length; i++) {
	
				System.out.println(M[i].ligar());
				System.out.println(M[i].operar());
				System.out.println(M[i].desligar());
			}
			
}
	 
}
