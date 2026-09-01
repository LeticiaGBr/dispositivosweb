package Strategy;
public class DescontoNenhum implements EstrategiaDesconto {
    @Override
    public double aplicarDesconto(double valor) {
        return valor;
    }
}