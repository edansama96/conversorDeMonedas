----
# Descripción del Proyecto
El Conversor de Monedas es una aplicación desarrollada en Java que permite realizar conversiones entre diferentes monedas utilizando datos actualizados de una API de tasas de cambio. Este proyecto está diseñado para ser modular, fácil de entender y extensible, con un enfoque en la separación de responsabilidades y el uso de buenas prácticas de programación.

El objetivo principal del proyecto es proporcionar un ejemplo práctico de cómo consumir una API REST, procesar datos en formato JSON utilizando la biblioteca Gson y estructurar un proyecto Java de manera clara y organizada.

----
# Estructura del Proyecto
El proyecto está organizado en las siguientes clases y paquetes:

1. **Main
Ubicación**: Raíz del proyecto.
Responsabilidad: Es el punto de entrada de la aplicación. Coordina la interacción con el usuario y llama a los métodos necesarios para realizar la conversión de monedas.
Detalles:
Muestra los códigos de moneda permitidos.
Solicita al usuario que seleccione las monedas y el valor a convertir.
Muestra el resultado de la conversión.
2. **ApiConexion
Ubicación**: Paquete api.
Responsabilidad: Maneja la conexión con la API de ExchangeRate-API.
Detalles:
Realiza solicitudes HTTP para obtener las tasas de cambio.
Filtra las monedas permitidas (máximo 6) y las devuelve como un mapa.
Maneja errores relacionados con la conexión o la respuesta de la API.
3. **Conversor
Ubicación**: Raíz del proyecto.
Responsabilidad: Representa los datos obtenidos de la API.
Detalles:
Es un record que almacena un mapa (Map<String, Double>) con las tasas de cambio (conversion_rates).
Facilita el acceso a los datos deserializados.
----
# Requisitos del Proyecto
1. **Dependencias
Java Development Kit (JDK)**: Versión 11 o superior.
2. **Biblioteca Gson**:
Para alidición de dicha biblioteca se agrego por medio del archivo jar y se utilizo la versión 2.13.1
3. **Clave de API** :
Regístrate en ExchangeRate-API para obtener una clave de API gratuita.
Reemplaza YOUR_API_KEY en el archivo ApiConexion.java con tu clave de API.

---
# Extensibilidad
1. **Agregar Más Monedas**
Modifica el método obtenerTasasFiltradas en la clase ApiConexion para incluir más códigos de moneda.
2. **Soporte para Todas las Monedas**
Si deseas trabajar con todas las monedas disponibles en la API, elimina el filtro en el método obtenerTasasFiltradas.
3. **Mejorar la Interfaz de Usuario**
Puedes agregar un menú interactivo o una interfaz gráfica para mejorar la experiencia del usuario.

---
# Funcionamiento:
1. **Menú principal**: Al ejercutar la aplicación se observara un menú el cual le permitira seleccionar al usuario entre ejecutar 
el proceso de conversiónd e monedas o salir de la aplicación.
Visualización del menú:
<pre>
                    *****************************************************
                    Sea bienvenido/a al Conversor de Moneda
                    
                    Por favor seleccione alguna de las siguientes opciones:
                    1) Para ingresar a realizar un cambio de moneda.
                    2) Salir.            
                    *****************************************************
  
</pre>
3. **Conversión**: En cada de que en el menú mencionado anteriormente se optara por la opción 1 se procede a mostrar las monedas filtradas en la aplicación,
para después permitir poder ingresar tanto la moneda base como la moneda a cambiar.
Visualización del la lista de monedas:
<pre>
                            *****************************************************
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
                            *****************************************************
</pre>
5. **Se obtiene el cambio**: Por el momento se está obteniendo el valor directamente de la conversión que se realizo por medio de la libreria Gson,
 con lo cual se observa las monedas manejadas, el rango de cambio a la moneda seleccionada y el cambio obtenido.
Respuesta obtenido:
<pre>
  base_code=USD, target_code=COP, conversion_rate=4226.1431, conversion_result=2113071.55
</pre>



---
# Notas Importantes
**Monedas Permitidas**:
La aplicación solo permite trabajar con un máximo de 6 monedas. Estas monedas están definidas en el método obtenerTasasFiltradas de la clase ApiConexion.
Puedes modificar los códigos de moneda permitidos en este método.

**Errores Comunes**:
Si la clave de API no es válida o la conexión a Internet falla, el programa mostrará un mensaje de error.
Si el usuario ingresa un código de moneda no permitido, el programa notificará que la moneda no está disponible.

**Extensibilidad**:
Puedes agregar más monedas permitidas modificando el método obtenerTasasFiltradas.
Si deseas trabajar con todas las monedas disponibles en la API, elimina el filtro en este método.

---
# Tecnologías Utilizadas
**Java**: Lenguaje de programación principal.
**Gson**: Biblioteca para procesar JSON.
**HTTP Client**: Para realizar solicitudes HTTP a la API.

---
**Contribuciones**

Si deseas contribuir al proyecto, puedes:

1. Mejorar la interfaz de usuario.
2. Agregar soporte para más monedas.
3. Optimizar el manejo de errores.

---
# Licencia
Este proyecto es de uso libre para fines educativos. Si utilizas este código, por favor da crédito al autor original.
primera versión.
