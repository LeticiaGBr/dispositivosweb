package Exemplo2;

public class Funcionario implements Pagavel {
	
	private String nome;
	private double SalarioBase;
	
	
	public Funcionario(String nome, double salarioBase) {
	
		this.nome = nome;
		this.SalarioBase = salarioBase;
		
	}



	public String getNome() {
		return nome;
	}
	
	
	
	public double getSalarioBase() {
		return SalarioBase;
	}
	public void setSalarioBase(double salarioBase) {
		SalarioBase = salarioBase;
	}
	



	@Override
	public double gerarPagamento() {
		
		
		return 1.3*SalarioBase;
	}
	
	

}
