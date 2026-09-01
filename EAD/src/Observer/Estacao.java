package Observer;
import java.util.ArrayList;
import java.util.List;

public class Estacao implements Sujeito {

    private double temperatura;
    private double umidade;
    private List<Observador> observadores = new ArrayList<>();

    @Override
    public void adicionarObservador(Observador o) {
        observadores.add(o);
    }

    @Override
    public void removerObservador(Observador o) {
        observadores.remove(o);
    }

    @Override
    public void notificarObservadores() {
        for (Observador o : observadores) {
            o.atualizar(temperatura, umidade);
        }
    }

    public void setDados(double temperatura, double umidade) {
        this.temperatura = temperatura;
        this.umidade = umidade;
        notificarObservadores();
    }
}