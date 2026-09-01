package Observer;
public class AlertaChuva implements Observador {
    @Override
    public void atualizar(double temperatura, double umidade) {
        if (umidade > 80) {
            System.out.println("[ALERTA] Alta chance de chuva! Umidade: " + umidade + "%");
        }
    }
}