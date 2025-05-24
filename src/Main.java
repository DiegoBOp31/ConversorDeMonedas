import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        GeneradorDeArchivos generador = new GeneradorDeArchivos();
        List<Moneda> historialDeCambios = new ArrayList<>();
        int opcionDeCambio;
        double cantidadAConvertir;

        while(true) {

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

            try {
                opcionDeCambio = Integer.parseInt(lectura.nextLine());
                if(opcionDeCambio == 9 ) {
                    break;
                }
                if (opcionDeCambio < 1 || opcionDeCambio > 8){
                    System.out.println("Opción inválida. Ingresa una opción del menú");
                    continue;
                }
                System.out.println("Ingresa el valor que deseas convertir: ");
                cantidadAConvertir = Double.parseDouble(lectura.nextLine());


                Moneda moneda = consulta.buscarCambio(opcionDeCambio, cantidadAConvertir);
                System.out.println("\nEl valor "+cantidadAConvertir+" ["+moneda.base_code()+"] corresponde al valor " +
                        "final de =>>> "+moneda.conversion_result() + " [" + moneda.target_code() + "]\n");
                historialDeCambios.add(moneda);
            }catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor ingresa un número");
            }catch (Exception e){
                System.out.println("Error al procesar la conversión: "+e.getMessage());
            }
        }
        generador.guardarJson(historialDeCambios);
        System.out.println("Finalizó el programa");
    }
}
