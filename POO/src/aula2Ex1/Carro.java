package aula2Ex1;

public class Carro {
	
	String modelo;
	String marca;
	int ano;
	Double velocidade;
	
	
	void acelerar(Double delta){
		velocidade = velocidade +delta;
	}
	void frear(Double delta) {
		if (velocidade - delta <0) {
			velocidade = 0.0;
		}else {
			velocidade = velocidade -delta;
		}
	}
	

}
