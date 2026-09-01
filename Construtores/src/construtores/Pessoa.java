package construtores;

public class Pessoa {
	private String CPF;
	private String Nome;
	
	public Pessoa(String Nome,String CPF) {
		this.Nome = Nome;
		this.CPF = CPF;
	}

	public String getCPF() {
		return CPF;
	}

	
	public String getNome() {
		return Nome;
	}

	
	
	
}
