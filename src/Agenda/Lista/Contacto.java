package Agenda.Lista;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

/**
 ************************
 * Clase : Contacto
 * Autor : Yon Cortes Bernal
 * Fecha : 05/2024
 * Version : 1.0
 * Testeo : No
 * Descripción : crea contactos para poder manejarlos en la lista
 ************************
 */

public class Contacto extends Persona implements Serializable{ /*Hay que implemetar la interfaz Serializable para poder convertir el objeto a bits para ser almacenado*/


    /**
     * Atributos
     * apodo : apodo único que se la va a dar al contacto
     * telefono : número de telefono con entero
     * email : mail del contacto como String
     */
    private String apodo;
    private int telefono;
    private String email;


    /*** Constructores ***/

    public Contacto(){
        super();
    }

    public Contacto(String nombre, String apellidos, LocalDate fecha, int telefono, String email, String apodo) {
        super(nombre, apellidos, fecha);
        this.telefono = telefono;
        this.email = email;
        this.apodo = apodo;
    }

    public Contacto(String nombre, String apellidos, LocalDate fecha, int telefono, String email) {
        super(nombre, apellidos, fecha);
        this.telefono = telefono;
        this.email = email;
    }




	@Override
	public String toString() {
		return "\n----------------------------\n" +
                apodo +
                "\n----------------------------" +
                "\nTelefono " + telefono +
                "\nEmail " + email + "\n" +
                super.toString();


	}

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }
}

