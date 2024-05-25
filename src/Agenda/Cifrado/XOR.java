package Agenda.Cifrado;

// Define el paquete donde se encuentra esta clase.

// La clase XOR extiende de la clase abstracta Cifrado.
public class XOR extends Cifrado {

    // Constructor vacío para la clase XOR.
    public XOR() {}

    // Implementación del método cifrar de la clase base.
    @Override
    public String cifrar(String texto, int clave) {
        // Llama al método operacionXOR con el texto y la clave.
        return operacionXOR(texto, clave);
    }

    // Implementación del método descifrar de la clase base.
    @Override
    public String descifrar(String texto, int clave) {
        // Llama al método operacionXOR con el texto y la clave.
        // Nota: la operación XOR es simétrica, así que cifrar y descifrar es lo mismo.
        return operacionXOR(texto, clave);
    }

    // Método privado que realiza la operación de cifrado/descifrado XOR.
    private String operacionXOR(String texto, int clave) {
        // Crea un StringBuilder para construir el resultado cifrado/descifrado.
        StringBuilder resultado = new StringBuilder();

        // Recorre cada carácter del texto.
        for (int i = 0; i < texto.length(); i++) {
            // Realiza la operación XOR entre el carácter y la clave, y añade el resultado al StringBuilder.
            resultado.append((char) (texto.charAt(i) ^ clave));
        }

        // Convierte el StringBuilder a una cadena y la retorna.
        return resultado.toString();
    }
}