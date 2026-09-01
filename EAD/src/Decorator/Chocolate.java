package Decorator;
public class Chocolate extends BebidaDecorator {

    public Chocolate(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao() + " + chocolate";
    }

    @Override
    public double getPreco() {
        return bebida.getPreco() + 1.50;
    }
}