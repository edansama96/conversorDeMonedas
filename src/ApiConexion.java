import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConexion {
    public Conversor convertirMoneda(String monedaBase, String monedaObjetivo, double valorDeCambio) {
        //Validación de   tipo de moneda
        if(!validarMoneda(monedaBase, monedaObjetivo)){
            System.out.println("Validación fallida");
        }

        if(valorDeCambio <= 0){
            System.out.println("El valor de cambio debe ser mayor");
        }


        try {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/934a6028c8d545d6afcc684c/pair/" + monedaBase
                + "/" + monedaObjetivo + "/" + valorDeCambio);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        // Envuar solicitud y recibir respuesta como String

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Conversor.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

   public boolean validarMoneda(String monedaBase, String monedaObjetivo){
       String[] monedasValidas = {"COP", "ARS", "BOB", "BRL", "CLP", "USD","JPY","JMD","LBP"};
       boolean baseValida = false;
       boolean objetivoValido = false;
        for(String moneda : monedasValidas){
            if(moneda.equalsIgnoreCase(monedaBase)){
                baseValida = true;
            }
            if(moneda.equalsIgnoreCase(monedaObjetivo)){
                objetivoValido = true;
            }

        }
        if (!baseValida){
            System.out.println("El código ingresado no es un elemento válido como moneda base.");

        }
        if (!objetivoValido) {
            System.out.println("El código ingresado no es un elemento válido como moneda de cambio.");

        }
       return baseValida && objetivoValido;
   }

}
