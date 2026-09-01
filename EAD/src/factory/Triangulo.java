package factory;
public class Triangulo implements Forma {
    @Override
    public double calcularArea(double... dimensoes) {
        double base = dimensoes[0];
        double altura = dimensoes[1];
        return (base * altura) / 2;
    }
}