package Observer;
import java.util.List;

public interface Sujeito {
    void adicionarObservador(Observador o);
    void removerObservador(Observador o);
    void notificarObservadores();
}