package Agenda.Cifrado;


/**
 ************************
 * Clase : Cifrado
 * Autor : Alejandro Gálvez Madueño
 * Fecha : 05/2024
 * Version : 1.0
 * Testeo : No
 * Descripción : Clase de cifrado
 ************************
 * */

public class Cifrado {
    //Claves para los cifrados
    private final int claveCesar = 3;
    private final int claveXOR = 111;

    /**
     * Constructor por defecto
     */
    public Cifrado(){}


    /**
     * Método cifradoXor
     * realiza una operación XOR sobre el array de bytes de la lista
     * @param arrayBytes
     * @return arrayBytes
     */
    public byte[] cifradoXor(byte[] arrayBytes){

        for (int i = 0; i < arrayBytes.length; i++) {
            arrayBytes[i] = (byte) (arrayBytes[i] ^ claveXOR);
        }

        return arrayBytes;
    }

    /**
     * Método cifradoCesar
     * realiza un cifrado cesar al array de bytes
     * @param arrayBytes
     * @return arrayBytes cifrado
     */
    public byte[] cifradoCesar(byte[] arrayBytes){

        for (int i = 0; i < arrayBytes.length; i++) {
            arrayBytes[i] = (byte) (arrayBytes[i] + claveCesar);
        }

        return arrayBytes;
    }

    /**
     * Método descifradoCesar
     * Descifra el array de bytes que ya ha sido cifreado con cesar
     * @param arrayBytes
     */
    public void descifradoCesar(byte[] arrayBytes){

        for (int i = 0; i < arrayBytes.length; i++) {
            arrayBytes[i] = (byte) (arrayBytes[i] - claveCesar);
        }

    }


}
