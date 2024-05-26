package Agenda.Lista;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Persona implements Serializable{

	String nombre;
	String apellidos;
	LocalDate fnac;


	public Persona(){}

	public Persona(String nombre, String apellidos, LocalDate fnac) {

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fnac = fnac;
	}



	@Override
	public String toString() {
		return "\nNombre y apellidos : " + nombre + " " + apellidos +
				"\nFecha de Nacimiento : " + fnac.toString() ;
	}
}
