package Aula2Ex2;

public class Principal {
	public static void main(String[] args) {
		ContaBancaria conta = new ContaBancaria();
		
		conta.setTitular("Carlos");
		conta.depositar(100.0);
		
		System.out.println("Titular:"+conta.getTitular());
		System.out.println("Saldo:"+conta.getSaldo());
	
		if(conta.Sacar(150.0) == true) {
			System.out.println("Saque realizado com secesso");
		}else {
			System.out.println("SAldo insuficiente");
		}
		System.out.println("Novo Saldo: "+ conta.getSaldo());
	}
}
