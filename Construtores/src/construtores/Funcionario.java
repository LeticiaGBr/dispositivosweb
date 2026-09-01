package construtores;

public class Funcionario extends Pessoa {

	private double salario;
	public Funcionario(String Nome, String CPF,double salario) {
		super(Nome, CPF);
		this.salario = salario;
	}
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}

	
}
