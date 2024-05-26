package Agenda.Menu;

import java.security.PublicKey;
import java.util.Scanner;

/**
 ************************
 * Clase : MenuPrincipal
 * Autor : Alejandro Gálvez Madueño
 * Fecha : 05/2024
 * Version : 1.0
 * Testeo : No
 * Descripción : Clase que muestra el menú principal y pide la opción que introduce el usuario
 ************************
 * */

public class MenuPrincipal extends Menu{

    private int opcion;

    /** Constructor por defecto */
    public MenuPrincipal(){
        opcion = -1;
    }

    /** Método pedirOpcion : pide al usuario introducir una opción y si no está en el rango correcto, imprime por pantalla un error */
    public void pedirOpcion(){
        Scanner sc = new Scanner(System.in);

        int o = -1;

        System.out.println("Opcion : ");
        o = sc.nextInt();

        opcion = o;
    }

    /** Método mostrarMenu : muestra el menú con las opciones que puede elegir el usuario*/
    public void mostrarMenu(){

        System.out.println(
                "1. Configuración de cifrado \n" +
                "2. Nuevo Contacto\n" +
                "3. Editar datos de contacto\n" +
                "4. Consultar Contacto\n" +
                "5. Eliminar Contacto\n" +
                "6. Obtener número de contactos\n" +
                "7. Generar lista en pantalla\n" +
                "8. Generar listado en fichero\n" +
                "0. Salir \n"
        );
    }


    public int getOpcion() {
        return opcion;
    }
}

