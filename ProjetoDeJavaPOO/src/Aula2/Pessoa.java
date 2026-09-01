package Aula2;

public class Pessoa {

	public String nome;
	public int Idade;
	
	public void Frase() {
		System.out.println("Olá "+nome+"Voce tem"+ Idade+" anos");
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return Idade;
	}

	public void setIdade(int idade) {
		Idade = idade;
	}
}
