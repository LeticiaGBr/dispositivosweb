package Aula2Ex2;

public class ContaBancaria {

	private String titular;
	private double saldo;
	
	public void depositar (Double Valor) {
		if (Valor <=0 ) {
			System.out.println("Deposito nao concluido");
		}else {
			saldo+=Valor;
		}
	}
	Boolean Sacar(Double Valor) {
		if (Valor <= saldo) {
			saldo -= Valor;
			return true;
		}else {
		return false;
		}
	}
	
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public double getSaldo() {
		return saldo;
	}
}

