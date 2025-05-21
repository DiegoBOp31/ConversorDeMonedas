import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        System.out.println("**************************************************");
        System.out.println("Sea bienvenid@ al Conversor de Moneda =]");
        System.out.println("Elija una opción válida:");
        System.out.println("\n1) Dólar =>> Peso mexicano");
        System.out.println("2) Peso mexicano =>> Dólar");
        System.out.println("3) Dólar =>> Peso argentino");
        System.out.println("4) Peso argentino =>> Dólar");
        System.out.println("5) Dólar =>> Real brasileño");
        System.out.println("6) Real brasileño =>> Dólar");
        System.out.println("7) Dólar =>> Peso colombiano");
        System.out.println("8) Peso colombiano =>> Dólar");
        System.out.println("9) Salir");
        System.out.println("**************************************************");
    }
}
