package Agenda.Lista;

import java.util.Scanner;

public class Contacto extends Persona {
	
	int telefono;
	String email;
	Scanner sc = new Scanner(System.in);
	
	
	public Contacto(String nombre, String apellidos, String fnac,int telefono,String email) {
		super(nombre, apellidos, fnac);
		this.telefono=telefono;
		this.email=email;
	}
	
	
	
	
	public int getTelefono() {
		return telefono;
	}




	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public Contacto nuevoContacto() {
		
		System.out.println("Ingrese los datos del nuevo contacto.");
		System.out.println("------------------------------------");
		
		System.out.println("Nombre: ");
		String nombre = sc.nextLine();
		
		System.out.println("Apellidos: ");
		String apellidos = sc.nextLine();
		
		System.out.println("Fecha de nacimiento: ");
		String fnac = sc.nextLine();
		
		System.out.println("Telefono: ");
		int telefono = sc.nextInt();
		
		System.out.println("Email: ");
		String email = sc.nextLine();
		
		
		return  new Contacto(nombre,apellidos,fnac,telefono,email);
	}
	
	public void editarContacto(Contacto a) {
		
		System.out.println("Nuevo nombre: ");
		String nombre = sc.nextLine();
		a.setNombre(nombre);
		
		System.out.println("Nuevos Apellidos: ");
		String apellidos = sc.nextLine();
		a.setApellidos(apellidos);
		
		System.out.println("Nueva Fecha de Nacimiento: ");
		String fnac = sc.nextLine();
		a.setFnac(fnac);
		
		System.out.println("Nuevo telefono: ");
		int telefono = sc.nextInt();
		a.setTelefono(telefono);
		
		System.out.println("Nuevo email: ");
		String email = sc.nextLine();
		a.setEmail(email);	
	}
	
	
	
	
	
	
}
