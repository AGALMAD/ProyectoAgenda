package Agenda.Lista;


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

    private int telefono;
    private String email;
    private Scanner sc = new Scanner(System.in);
  
    public Contacto(String nombre, String apellidos, String fecha, int telefono, String email) {
        super(nombre, apellidos, fecha);
        this.telefono = telefono;
        this.email = email;
    }

    //metodo para crear contacto
    
    public static Contacto crearContacto() {
    	//creo un contacto vacio
        Contacto contacto = new Contacto("", "", "", 0, ""); 
        // le pido los datos
        contacto.pedirDatos(); 
        //me devuelve el contacto relleno
        return contacto;
    }
    
 // Método para editar los datos de un contacto
    public void editarContacto(Contacto[] contactos) {
        System.out.println("Ingrese el criterio de búsqueda (nombre, apellido):");
        String criterio = sc.nextLine();
        System.out.println("Ingrese el valor del criterio de búsqueda:");
        String valor = sc.nextLine();

        Contacto contactoEncontrado = buscarContacto(criterio, valor, contactos);
        if (contactoEncontrado != null) {
            System.out.println("Editar contacto:");
            System.out.println("Datos actuales del contacto:");
            System.out.println(contactoEncontrado.toString());
            contactoEncontrado.pedirDatos(); // Edita los datos del contacto encontrado
            System.out.println("¡Contacto actualizado correctamente!");
        } else {
            System.out.println("No se encontró ningún contacto con el criterio proporcionado.");
        }
    }
    
    public void mostrarContacto(Contacto[] contactos) {
    	
    	 System.out.println("Ingrese el criterio de búsqueda (nombre, apellido):");
         String criterio = sc.nextLine();
         System.out.println("Ingrese el valor del criterio de búsqueda:");
         String valor = sc.nextLine();
         Contacto contactoEncontrado = buscarContacto(criterio, valor, contactos);
         if (contactoEncontrado != null) {
             
             System.out.println("Datos actuales del contacto:");
             System.out.println(contactoEncontrado.toString());
         } else {
             System.out.println("No se encontró ningún contacto con el criterio proporcionado.");
         }
    }
    
    public void pedirDatos() {
        System.out.println("Ingrese los datos del contacto:");

        System.out.print("Nombre: ");
        this.nombre = sc.nextLine();

        System.out.print("Apellidos: ");
        this.apellidos = sc.nextLine();

        System.out.print("Fecha de nacimiento dd/MM/yyyy : ");
        String cadena = sc.nextLine();
        comprobarFecha(cadena);
        
        

        System.out.print("Teléfono: ");
        this.telefono = sc.nextInt();

        
        sc.nextLine();

        System.out.print("Email: ");
        this.email = sc.nextLine();
    }
    
    public Contacto buscarContacto(String criterio, String valor,Contacto[] contactos) {
    	
        for (Contacto contacto : contactos) {
            switch (criterio.toLowerCase()) {
                case "nombre":
                    if (contacto.getNombre().equalsIgnoreCase(valor)) {
                        return contacto;
                    }
                    break;
                case "apellido":
                    if (contacto.getApellidos().equalsIgnoreCase(valor)) {
                        return contacto;
                    }
                    break;
  
            }
        }
        return null; 
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
    
	
    
}

