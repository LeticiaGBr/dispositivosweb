package Revisao;

public class Principal {

	public static void main(String[] args) {
		Animal a=new Animal("Idnefinida");
		Gato g = new Gato("Gato");
		Cachorro c = new Cachorro("Cachorro");
		
		Animal[] animais =  new Animal[]{a,g,c};
		for (int i = 0; i < animais.length; i++) {
			animais[i].emitirSom();
			if(animais[i] instanceof Gato){
					 Gato gato = (Gato) animais[i];//Dowcast
					 gato.ronronar();
				}
			else if (animais[i] instanceof Cachorro) {
				Cachorro cachorro = (Cachorro) animais[i];
				cachorro.abanarabo();
			}
			}
		
	}
}
