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


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public Date getFnac() {
		return fnac;
	}


	public void setFnac(Date fnac) {
		this.fnac = fnac;
	}


	@Override
	public String toString() {
		return "\nNombre y apellidos : " + nombre + " " + apellidos +
				"\nFecha de Nacimiento : " + fnac.getDay() + "/" + fnac.getMonth()  +  "/" + fnac.getYear()  ;
	}
}
