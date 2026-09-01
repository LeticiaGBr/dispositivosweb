package singleton;
public class Main {
    public static void main(String[] args) {

        Configuracao c1 = Configuracao.getInstance();
        Configuracao c2 = Configuracao.getInstance();

        c1.setNomeApp("Sistema Escolar");
        c1.setVersao("1.0");
        c1.setIdioma("PT-BR");

        // Acessando pelos dois objetos
        System.out.println(c2.getNomeApp());
        System.out.println(c2.getVersao());
        System.out.println(c2.getIdioma());

        // Verificando se é o mesmo objeto
        System.out.println(c1 == c2); // true
    }
}