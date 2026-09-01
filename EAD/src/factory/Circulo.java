package factory;
public class Circulo implements Forma {
    @Override
    public double calcularArea(double... dimensoes) {
        double raio = dimensoes[0];
        return Math.PI * raio * raio;
    }
}