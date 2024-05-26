package Agenda.Cifrado;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

    protected int clave;

    public Cifrado(int clave){
        this.clave = clave;
    }

    public void descifrar(ObjectInputStream fichero){



    }



}
