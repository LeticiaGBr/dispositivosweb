package Strategy;
public class Carrinho {

    private double total;
    private EstrategiaDesconto estrategia;

    public Carrinho(double total) {
        this.total = total;
    }

    public void setEstrategia(EstrategiaDesconto estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularTotalComDesconto() {
        if (estrategia == null) {
            throw new IllegalStateException("Estratégia de desconto não definida");
        }
        return estrategia.aplicarDesconto(total);
    }
}