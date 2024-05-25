package Agenda.Cifrado;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfiguracionCifrado {

    private Cifrado cifrado;
    private int clave;

    public ConfiguracionCifrado(Cifrado cifrado, int clave) {
        this.cifrado = cifrado;
        this.clave = clave;
    }

    public void cifrarArchivo(String filePath) throws IOException {
        // Leer el contenido del archivo en bytes
        byte[] fileContent = Files.readAllBytes(Paths.get(filePath));

        // Convertir los bytes a String (texto)
        String texto = new String(fileContent);

        // Aplicar el cifrado
        String textoCifrado = cifrado.cifrar(texto, clave);

        // Escribir el contenido cifrado de vuelta al archivo
        Files.write(Paths.get(filePath), textoCifrado.getBytes());
    }

    public void descifrarArchivo(String filePath) throws IOException {
        // Leer el contenido del archivo en bytes
        byte[] fileContent = Files.readAllBytes(Paths.get(filePath));

        // Convertir los bytes a String (texto)
        String texto = new String(fileContent);

        // Aplicar el descifrado
        String textoDescifrado = cifrado.descifrar(texto, clave);

        // Escribir el contenido descifrado de vuelta al archivo
        Files.write(Paths.get(filePath), textoDescifrado.getBytes());
    }
}