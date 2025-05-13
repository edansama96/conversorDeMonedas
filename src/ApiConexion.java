import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ApiConexion {
    public Conversor convertirMoneda(String monedaBase, String monedaObjetivo, double valorDeCambio) {
        //Validación de   tipo de moneda
        if(!validarMoneda(monedaBase, monedaObjetivo)){
            System.out.println("Validación fallida");
        }

        if(valorDeCambio <= 0){
            System.out.println("El valor de cambio debe ser mayor");
        }

        //Crear un objeto Properties para poder manejar y cargar la key del api
        Properties properties = new Properties();

        try {
            //Carga del archivo config.properties
            FileInputStream inputStream = new FileInputStream("src/config.properties");
            properties.load(inputStream);
            // Se obtiene la clave del API
            String apiKey = properties.getProperty("api.key");

            //Al crear la URL se manejan 4 elementos los datos ingresados por el usuairo que son
            // la moneda base
            // la moneda de cambio
            // el valor a cambiar
            // y el apikey que se obteniene al realizar el proceso por medio de exchangerateapi
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/" + monedaBase
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
