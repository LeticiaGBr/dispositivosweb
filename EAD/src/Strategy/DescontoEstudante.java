package Strategy;
public class DescontoEstudante implements EstrategiaDesconto {
    @Override
    public double aplicarDesconto(double valor) {
        return valor * 0.85;
    }
}