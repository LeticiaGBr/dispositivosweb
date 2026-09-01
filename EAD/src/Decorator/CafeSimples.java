package Decorator;
public class CafeSimples implements Bebida {

    @Override
    public String getDescricao() {
        return "Café simples";
    }

    @Override
    public double getPreco() {
        return 3.50;
    }
}