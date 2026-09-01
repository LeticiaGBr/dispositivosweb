package factory;
public class FormaFactory {

    public static Forma criarForma(String tipo) {
        switch (tipo.toLowerCase()) {
            case "circulo":
                return new Circulo();
            case "quadrado":
                return new Quadrado();
            case "triangulo":
                return new Triangulo();
            default:
                throw new IllegalArgumentException("Forma desconhecida: " + tipo);
        }
    }
}