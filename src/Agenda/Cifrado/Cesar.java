package Agenda.Cifrado;

// Define el paquete donde se encuentra esta clase.

// La clase Cesar extiende de la clase abstracta Cifrado.
public class Cesar extends Cifrado {

    // Define un atributo de tipo Character para la clave (aunque no se usa en esta clase).
    private Character clave;

    // Constructor vacío para la clase Cesar.
    public Cesar() {}

    // Implementación del método cifrar de la clase base.
    @Override
    public String cifrar(String texto, int clave) {
        // Llama al método operacionCesar con el texto y la clave.
        return operacionCesar(texto, clave);
    }

    // Implementación del método descifrar de la clase base.
    @Override
    public String descifrar(String texto, int clave) {
        // Llama al método operacionCesar con el texto y la clave negativa para descifrar.
        return operacionCesar(texto, -clave);
    }

    // Método privado que realiza la operación de cifrado/descifrado César.
    private String operacionCesar(String texto, int desplazamiento) {
        // Crea un StringBuilder para construir el resultado cifrado/descifrado.
        StringBuilder resultado = new StringBuilder();

        // Recorre cada carácter del texto.
        for (int i = 0; i < texto.length(); i++) {
            // Obtiene el carácter en la posición 'i' del texto.
            char c = texto.charAt(i);

            // Verifica si el carácter es una letra.
            if (Character.isLetter(c)) {
                // Determina la base ('A' para mayúsculas, 'a' para minúsculas).
                char base = Character.isUpperCase(c) ? 'A' : 'a';

                // Realiza la operación de cifrado César y ajusta el carácter.
                c = (char) ((c - base + desplazamiento + 26) % 26 + base);
            }

            // Añade el carácter resultante al StringBuilder.
            resultado.append(c);
        }

        // Convierte el StringBuilder a una cadena y la retorna.
        return resultado.toString();
    }
}
