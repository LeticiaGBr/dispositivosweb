package Exemplo2;

public class Fatura implements Pagavel {
	private double valorBase;

	public Fatura(double valorBase) {
		super();
		this.valorBase = valorBase;
	}

	public double getValorBase() {
		return valorBase;
	}

	public void setValorBase(double valorBase) {
		this.valorBase = valorBase;
	}

	@Override
	public double gerarPagamento() {
		return 1.2 * valorBase;
	}

}
