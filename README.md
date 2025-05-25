# 💱 Conversor de Monedas en Java

Este proyecto es una aplicación de consola escrita en Java que permite convertir valores monetarios entre distintas monedas usando datos de una API externa. 
El usuario puede seleccionar una opción del menú, ingresar una cantidad, y el programa mostrará el valor convertido y lo guardará en un historial.

---

## 🧠 ¿Qué resuelve este proyecto?

Este conversor:
- Permite elegir entre 8 conversiones distintas de moneda (por ejemplo: Dólar a Peso Mexicano).
- Hace peticiones a una API externa para obtener el tipo de cambio en tiempo real.
- Convierte la cantidad ingresada por el usuario y la muestra por consola.
- Guarda el historial de conversiones exitosas en un archivo `.json`.

---

## 🔧 Tecnologías utilizadas

- Java 21
- API HTTP con `HttpURLConnection`
- Parsing de JSON con Gson
- Manejo de entradas por consola (`Scanner`)
- Estructuras de control como `switch`, `while`, `try-catch`

---

## 🧪 Validaciones implementadas

- Se valida que el usuario ingrese una opción del 1 al 9 (salir).
- Si elige una opción no válida (fuera del rango), se le vuelve a mostrar el menú.
- Si ingresa texto no numérico como cantidad, se maneja la excepción para evitar que el programa se rompa.
- Si la API devuelve una respuesta inesperada (por ejemplo, texto en vez de JSON), se captura el error y se informa al usuario.

---

## 🐛 Problemas encontrados y cómo los resolvimos

### ❌ Error: `Expected BEGIN_OBJECT but was STRING`

Este error ocurría cuando el programa esperaba que la respuesta de la API fuera un JSON en forma de objeto, pero en realidad llegaba como un string (por ejemplo, un mensaje de error o texto plano).

**🔧 Solución:**
- Se imprimió la respuesta cruda de la API para verificar su formato.
- Se agregó una validación que comprueba si la respuesta empieza con `{` antes de intentar convertirla a un objeto con Gson.
- Si no es un objeto válido, se lanza una excepción personalizada.



