package Observer;
public class Main {
    public static void main(String[] args) {

        Estacao estacao = new Estacao();

        Observador display = new Display();
        Observador alerta = new AlertaChuva();
        Observador registro = new RegistroDiario();

        estacao.adicionarObservador(display);
        estacao.adicionarObservador(alerta);
        estacao.adicionarObservador(registro);

        // Atualizações
        estacao.setDados(25, 60);
        System.out.println("------");
        estacao.setDados(22, 85);
    }
}