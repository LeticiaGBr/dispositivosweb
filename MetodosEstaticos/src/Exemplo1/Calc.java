package Exemplo1;

public class Calc {

	public static double Somar(double a, double b) {
		return a+b;
	}

	public static double Subtrair(double a, double b) {
		return a+b;
	}

	public static double Multiplicar(double a, double b) {
		return a*b;
	}

	public static double dividr(double a, double b) {
		if(b != 0) {
			return a/b;
		}else {
			System.out.println("Divisao invalida;denomindor 0");
			return Double.NaN;
		}
	}



	
}
