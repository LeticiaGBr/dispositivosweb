package Dispositovos;

public class Tela {
	public static void main(String[] args) {
			PCDesktop pc = new PCDesktop();
			Mobile cel = new Mobile();
			
			pc.Iniciar();
			System.out.println("_________________");
			cel.Iniciar(); 
	}
}
