import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConexion {
    public Conversor convertirMoneda(String monedaBase, String monedaObjetivo, double valorDeCambio) {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/934a6028c8d545d6afcc684c/pair/" + monedaBase
                + "/" + monedaObjetivo + "/" + valorDeCambio);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        // Envuar solicitud y recibir respuesta como String
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversor.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
