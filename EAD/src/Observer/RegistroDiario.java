package Observer;
import java.time.LocalDateTime;

public class RegistroDiario implements Observador {
    @Override
    public void atualizar(double temperatura, double umidade) {
        System.out.println("[LOG] " + LocalDateTime.now() +
                " | Temp: " + temperatura +
                " | Umidade: " + umidade);
    }
}