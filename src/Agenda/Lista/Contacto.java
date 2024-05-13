package Agenda.Lista;


import java.util.Date;
import java.util.Scanner;

/**
 ************************
 * Clase : Agenda.Lista.Contacto
 * Autor : Yon Cortes Bernal
 * Fecha : 05/2024
 * Version : 0.0
 * Testeo : No
 * Descripción : Clase Contacto
 ************************
 */

public class Contacto extends Persona {

    private String apodo;
    private int telefono;
    private String email;
    private Scanner sc = new Scanner(System.in);
  
    public Contacto(String nombre, String apellidos, Date fecha, int telefono, String email, String apodo) {
        super(nombre, apellidos, fecha);
        this.telefono = telefono;
        this.email = email;
        this.apodo = apodo;
    }

    public Contacto(String nombre, String apellidos, Date fecha, int telefono, String email) {
        super(nombre, apellidos, fecha);
        this.telefono = telefono;
        this.email = email;
    }




    



	@Override
	public String toString() {
		return "Contacto [telefono=" + telefono + ", email=" + email + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", fnac=" + fnac + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }
}

