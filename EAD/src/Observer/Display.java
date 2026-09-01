package Observer;
public class Display implements Observador {
    @Override
    public void atualizar(double temperatura, double umidade) {
        System.out.println("[DISPLAY] Temp: " + temperatura + "°C | Umidade: " + umidade + "%");
    }
}