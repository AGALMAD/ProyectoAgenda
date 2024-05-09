package Agenda.Lista;

/**
 ************************
 * Clase : Agenda.Lista
 * Autor : Alejandro Gálvez Madueño
 * Fecha : 05/2024
 * Version : 0.0
 * Testeo : No
 * Descripción : Clase de cifrado
 ************************
 * */

public class Lista {

    private Persona[] listaContactos;

    /**
     * Constructor por defecto de la lista, crea la lista y la inicializa todo a null
     */
    public Lista(){

        listaContactos = new Persona[numeroContactos];

        for (int i = 0; i < listaContactos.length; i++) {

            listaContactos[i] = null;
        }

    }

    private static int numeroContactos;





}
