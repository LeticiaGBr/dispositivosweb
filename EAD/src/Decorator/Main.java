package Decorator;

public class Main {
    public static void main(String[] args) {

        // Café simples
        Bebida cafe = new CafeSimples();
        System.out.println(cafe.getDescricao() + " = R$ " + cafe.getPreco());

        // Café com leite
        Bebida cafeComLeite = new Leite(new CafeSimples());
        System.out.println(cafeComLeite.getDescricao() + " = R$ " + cafeComLeite.getPreco());

        // Café com chocolate
        Bebida cafeComChocolate = new Chocolate(new CafeSimples());
        System.out.println(cafeComChocolate.getDescricao() + " = R$ " + cafeComChocolate.getPreco());

        // Café com leite e chocolate (combinação)
        Bebida completo = new Chocolate(new Leite(new CafeSimples()));
        System.out.println(completo.getDescricao() + " = R$ " + completo.getPreco());
    }
}