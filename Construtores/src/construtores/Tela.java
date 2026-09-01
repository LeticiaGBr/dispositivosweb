package construtores;

public class Tela {
	public static void main(String[] args) {
		Produto p = new Produto();
		Produto p2 = new Produto("Pao",5.0);
		Produto p3 = new Produto("Pao");
		
		System.out.println("Produto 1:"+p.getNome() +" " + p.getPreco());
		System.out.println("Produto 1:"+p2.getNome() +" " + p2.getPreco());
		System.out.println("Produto 1:"+p3.getNome() +" " + p3.getPreco());
		
		Pessoa pessoa = new Pessoa("Carlin maia","1256456432");
		System.out.println("Nome"+ pessoa.getNome()+ " CPF"+pessoa.getCPF());
		
		Funcionario f = new Funcionario("Carlos","2313213",2000);
		System.out.println(f.getNome());
		System.out.println(f.getCPF());
		System.out.println(f.getSalario());
	}
}
