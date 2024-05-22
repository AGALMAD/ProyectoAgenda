package Agenda.Lista;

import java.io.Serializable;
import java.util.Date;

public class Persona implements Serializable{

	String nombre;
	String apellidos;
	Date fnac;


	public Persona(){}

	public Persona(String nombre, String apellidos, Date fnac) {

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fnac = fnac;
	}



	@Override
	public String toString() {
		return "\nNombre y apellidos : " + nombre + " " + apellidos +
				"\nFecha de Nacimiento : " + fnac.getDay() + "/" + fnac.getMonth()  +  "/" + fnac.getYear()  ;
	}
}
