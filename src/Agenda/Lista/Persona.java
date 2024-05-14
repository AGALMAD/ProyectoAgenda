package Agenda.Lista;

import java.util.Date;

public class Persona {
	String nombre;
	String apellidos;
	Date fnac;


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
