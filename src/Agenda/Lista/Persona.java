package Agenda.Lista;
/**
 ************************
 * Clase : Agenda.Lista.Persona
 * Autor : Yon Cortes Bernal
 * Fecha : 05/2024
 * Version : 0.0
 * Testeo : No
 * Descripción : Clase Persona
 ************************
 * */

public class Persona {
	String nombre;
	String apellidos;
	String fnac;
	
	
	public Persona(String nombre, String apellidos, String fnac) {
		
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


	public String getFnac() {
		return fnac;
	}


	public void setFnac(String fnac) {
		this.fnac = fnac;
	}
	
	
	
	
}
