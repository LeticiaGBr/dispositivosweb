package construtores;

public class Produto {
	
	//Atributos
	private double preco;
	private String nome;
	
	//construtores
	
	public Produto() {
		nome ="Desconhecido";
		preco=0;
	}
	public Produto(String nome) {
		this.nome = nome;
		preco = 0;
	}
	public Produto(String nome,double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	
	
	
	
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
