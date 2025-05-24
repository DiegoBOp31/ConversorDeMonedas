import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public Moneda buscarCambio(int eleccionMenu, double cantidad){

        URI direccion = null;
        switch (eleccionMenu) {//Aquí sólo construimos la URL para hacer el cambio
            case 1:
                 direccion = URI
                        .create("https://v6.exchangerate-api.com/v6/4c64c2279ba23174e7c55f28/pair/USD/MXN/" + cantidad);
                break;
            case 2:
                direccion = URI
                        .create("https://v6.exchangerate-api.com/v6/4c64c2279ba23174e7c55f28/pair/MXN/USD/" + cantidad);
                break;
            case 3:
                direccion = URI
                        .create("https://v6.exchangerate-api.com/v6/4c64c2279ba23174e7c55f28/pair/USD/ARS/" + cantidad);
                break;
            case 4:
                direccion = URI
                        .create("https://v6.exchangerate-api.com/v6/4c64c2279ba23174e7c55f28/pair/ARS/USD/" + cantidad);
                break;
            case 5:
                direccion = URI
                        .create("https://v6.exchangerate-api.com/v6/4c64c2279ba23174e7c55f28/pair/USD/BRL/" + cantidad);
                break;
            case 6:
                direccion = URI
                        .create("https://v6.exchangerate-api.com/v6/4c64c2279ba23174e7c55f28/pair/BRL/USD/" + cantidad);
                break;
            case 7:
                direccion = URI
                        .create("https://v6.exchangerate-api.com/v6/4c64c2279ba23174e7c55f28/pair/USD/COP/" + cantidad);
                break;
            case 8:
                direccion = URI
                        .create("https://v6.exchangerate-api.com/v6/4c64c2279ba23174e7c55f28/pair/COP/USD/" + cantidad);
                break;
        }


        //Crea un "cliente HTTP", es decir, algo que puede hacer peticiones a internet
        HttpClient client = HttpClient.newHttpClient();
        /*
         Se prepara la solicitud para pedir datos desde la dirección web.
        .uri (direccion) = indica a dónde vamos a conectarnos.
        .build() = termina de construir la solicitud.
         */
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try{
            //Manda esta solicitud al servidor y guarda la respuesta (como texto) en una variable llamada response
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //fromJson(response.body()) convierte el texto JSON que nos dio la API en un objeto Java llamado Moneda
            return new Gson().fromJson(response.body(), Moneda.class);
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }



    }
}
