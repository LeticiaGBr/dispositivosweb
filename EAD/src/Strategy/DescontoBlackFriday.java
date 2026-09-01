package Strategy;
public class DescontoBlackFriday implements EstrategiaDesconto {
    @Override
    public double aplicarDesconto(double valor) {
        return valor * 0.60;
    }
}