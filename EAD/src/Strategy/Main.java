package Strategy;
public class Main {
    public static void main(String[] args) {

        Carrinho carrinho = new Carrinho(100.0);

        // Sem desconto
        carrinho.setEstrategia(new DescontoNenhum());
        System.out.println("Sem desconto: " + carrinho.calcularTotalComDesconto());

        // Estudante
        carrinho.setEstrategia(new DescontoEstudante());
        System.out.println("Desconto estudante: " + carrinho.calcularTotalComDesconto());

        // Black Friday
        carrinho.setEstrategia(new DescontoBlackFriday());
        System.out.println("Black Friday: " + carrinho.calcularTotalComDesconto());
    }
}