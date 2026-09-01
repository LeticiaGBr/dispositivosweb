package singleton;
public class Configuracao {

    // Instância única
    private static Configuracao instancia;

    // Atributos da configuração
    private String nomeApp;
    private String versao;
    private String idioma;

    // Construtor privado
    private Configuracao() {}

    // Método de acesso global
    public static Configuracao getInstance() {
        if (instancia == null) {
            instancia = new Configuracao();
        }
        return instancia;
    }

    // Getters e Setters
    public String getNomeApp() {
        return nomeApp;
    }

    public void setNomeApp(String nomeApp) {
        this.nomeApp = nomeApp;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}
