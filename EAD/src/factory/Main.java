package factory;
public class Main {
    public static void main(String[] args) {

        Forma f1 = FormaFactory.criarForma("circulo");
        Forma f2 = FormaFactory.criarForma("quadrado");
        Forma f3 = FormaFactory.criarForma("triangulo");

        double areaCirculo = f1.calcularArea(3);          // raio
        double areaQuadrado = f2.calcularArea(4);         // lado
        double areaTriangulo = f3.calcularArea(5, 2);     // base, altura

        System.out.println("Área do círculo: " + areaCirculo);
        System.out.println("Área do quadrado: " + areaQuadrado);
        System.out.println("Área do triângulo: " + areaTriangulo);
    }
}