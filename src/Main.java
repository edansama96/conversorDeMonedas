import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ApiConexion convetir = new ApiConexion();

        System.out.println("Escriba el código de la moneda base a cambiar:");
        var monedaBase = teclado.nextLine();
        System.out.println("Escriba el código de la moneda a convetir: ");
        var monedaConvertir = teclado.nextLine();
        System.out.println("Ingrese el valor númerico a convertir: ");
        var valorUsuario = teclado.nextDouble();
        Conversor cambio = convetir.convertirMoneda(monedaBase, monedaConvertir, valorUsuario);
        System.out.println(cambio);

        // //Varaibles para usar la URL del API y validar el funcionamiento
        // String apiUrl=
        // "https://v6.exchangerate-api.com/v6/934a6028c8d545d6afcc684c/latest/USD";
        //
        // //Crear una instancia de Gson
        // Gson gson = new Gson();
        //
        // //Crear cliente HTTP
        // HttpClient client = HttpClient.newHttpClient();
        //
        // //Crear solicitud GET
        // HttpRequest request = HttpRequest.newBuilder()
        // .uri(URI.create(apiUrl))
        // .GET()
        // .build();
        //
        // // Envuar solicitud y recibir respuesta como String
        // try {
        // HttpResponse<String> response = client.send(request,
        // HttpResponse.BodyHandlers.ofString());
        // System.out.println("El estatus es: " + response.statusCode()+"\n");
        // System.out.println("El cuerpo de la respuesta es: "+ response.body());
        // } catch (IOException e) {
        // throw new RuntimeException(e);
        // } catch (InterruptedException e) {
        // throw new RuntimeException(e);
        // }

    }
}
