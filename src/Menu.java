import java.util.Scanner;

public class Menu {
    public void menuEje() {
        boolean funcionamiento = true;
        Scanner teclado = new Scanner(System.in);
        ApiConexion convertir = new ApiConexion();

        while (funcionamiento) {
            System.out.println("""
                    *****************************************************
                    Sea bienvenido/a al Conversor de Moneda
                    
                    Por favor seleccione alguna de las siguientes opciones:
                    1) Para ingresar a realizar un cambio de moneda.
                    2) Salir.            
                    """);

            int casos = teclado.nextInt();
            teclado.nextLine(); // Limpiar el buffer después del nextInt

            switch (casos) {
                case 1:
                    System.out.println("""
                            Para la moneda base puede escribir entre el siguiente listado de monedas:
                            1) ARS - Peso Argentino
                            2) BOB - Boliviano
                            3) BRL - Real brasileño
                            4) CLP - Peso chileno
                            5) COP - Peso colombiano
                            6) USD - Dólar estadounidense
                            7) JPY - Yen japonés
                            8) JMD - Dólar jamaicano
                            9) LBP - Libra libanesa
                            """);

                    System.out.println("Escriba el código de la moneda base a cambiar:");
                    String monedaBase = teclado.nextLine();

                    System.out.println("Escriba el código de la moneda a convertir:");
                    String monedaConvertir = teclado.nextLine();

                    System.out.println("Ingrese el valor numérico a convertir:");
                    double valorUsuario = teclado.nextDouble();
                    teclado.nextLine(); // Limpiar buffer después del nextDouble, por si repite el menú

                    Conversor cambio = convertir.convertirMoneda(monedaBase, monedaConvertir, valorUsuario);
                    System.out.println(cambio);
                    break;

                case 2:
                    System.out.println("La aplicación finaliza su funcionamiento. ¡Gracias por su uso!");
                    funcionamiento = false; // salir del bucle
                    break;

                default:
                    System.out.println("Por favor seleccione una opción válida del menú.");
                    break;
            }
        }

        teclado.close(); // buena práctica cerrar el Scanner


    }


}

