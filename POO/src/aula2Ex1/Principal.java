package aula2Ex1;

public class Principal {
	public static void main(String[] args) {
		// Instaciando
		Carro c1 = new Carro();
		Carro c2 = new Carro();
		//setando valores
		c1.ano = 2000;
		c1.marca = "Volskvagem";
		c1.modelo = "Celtinha";
		c1.velocidade = 0.0;
		//setando valores
		c2.ano = 1967;
		c2.modelo ="Impala";
		c2.marca = "Chervolet";
		c2.velocidade = 0.0;
		//Chamando os metodos
		c1.acelerar(40.0);
		c2.acelerar(50.5);
		
		//monstrando valores na telinha
		System.out.println("Velocidade do "+c1.modelo+ " " + c1.velocidade);
		System.out.println("Velocidade do "+c2.modelo+ " " + c2.velocidade);
		
		
		c1.frear(50.0);
		c2.frear(0.5);
		System.out.println("Frear.");
		System.out.println("Velocidade do "+c1.modelo+ " " + c1.velocidade);
		System.out.println("Velocidade do "+c2.modelo+ " " + c2.velocidade);

	}
}
