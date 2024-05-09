package Agenda.Cifrado;

/**
 ************************
 * Clase : Agenda.Cifrado
 * Autor : Alejandro Gálvez Madueño
 * Fecha : 05/2024
 * Version : 0.0
 * Testeo : No
 * Descripción : Clase de cifrado
 ************************
 * */

public class Cifrado {

    /** Atributo tipoCifrado : Almacena el tipo de cifrado que se va a utilizar**/
    private Tipo tipoCifrado;

    private enum Tipo{XOR, CESAR};

    /**
     * Construtor para el cifrado, se le pasa el tipo de cifrado como un String y se pasa a Tipo
     * @param cifrado : String con el tipo de cifrado
     */
    public Cifrado(String cifrado){

        tipoCifrado = Tipo.valueOf(cifrado);

    }


    public Tipo getTipoCifrado() {
        return tipoCifrado;
    }
}
