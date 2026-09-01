package Exemplo2;

public class Main {
	public static void main(String[] args) {
		Pagavel[] t = new Pagavel[4];
		t[0] = new Funcionario("Gustavo",1000);
		t[1] = new Fatura(300);
		t[2] = new Fatura(2000);
		t[3] = new Funcionario("CarlinDoPlay",1628);
		for (int i = 0; i < t.length; i++) {
			double pago = t[i].gerarPagamento();
			System.out.println(pago);
		}
	}
}
