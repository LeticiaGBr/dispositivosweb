package factory;

public class Quadrado implements Forma {
    @Override
    public double calcularArea(double... dimensoes) {
        double lado = dimensoes[0];
        return lado * lado;
    }
}