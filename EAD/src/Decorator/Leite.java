package Decorator;
public class Leite extends BebidaDecorator {

    public Leite(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao() + " + leite";
    }

    @Override
    public double getPreco() {
        return bebida.getPreco() + 1.00;
    }
}