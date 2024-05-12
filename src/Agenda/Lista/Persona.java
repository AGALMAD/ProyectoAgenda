package Agenda.Lista;

/**
 ************************
 * Clase : Agenda.Lista.Contacto
 * Autor : Yon Cortes Bernal
 * Fecha : 05/2024
 * Version : 0.0
 * Testeo : No
 * Descripción : Clase Persona
 ************************
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Persona {
    protected String nombre;
    protected String apellidos;
    protected Date fnac;
    
    /* Constructor pasándole nombre, apellidos y fecha de nacimiento */
    public Persona(String nombre, String apellidos, String fecha) {
        this.nombre = nombre; 
        this.apellidos = apellidos; 
        comprobarFecha(fecha);
    }
    
    
    public void comprobarFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fechaConvertida = formato.parse(fecha);
            this.fnac = fechaConvertida;
        } catch (ParseException e) {
            System.out.println("Fecha inválida, asignamos una por defecto");
            try {
            	this.fnac = formato.parse("01/01/2024");
            }catch (ParseException ex) {
            	 e.printStackTrace();
            }
           
        }
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
    
    
}


