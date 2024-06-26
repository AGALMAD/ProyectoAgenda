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

public abstract class Cifrado {

    public abstract String cifrar(String texto, int clave);
    public abstract String descifrar(String texto, int clave);



}
