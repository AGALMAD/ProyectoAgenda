package Agenda.Menu;

import Agenda.Menu.Menu;

import java.util.Scanner;

/**
 ************************
 * Clase : Menu Agenda.Cifrado
 * Autor : Alejandro Gálvez Madueño
 * Fecha : 05/2024
 * Version : 1.0
 * Testeo : No
 * Descripción : Clase que muestra el menú de los tipos de Cifrado y pide la opción que introduce el usuario
 ************************
 * */
public class MenuCifrado extends Menu {

    private String tipoCifrado;

    /** Constructor por defecto */
    public MenuCifrado(){
        tipoCifrado = "XOR";
    }

    /** Método pedirOpcion : pide al usuario introducir una opción y si no está en el rango correcto, imprime por pantalla un error */
    public void pedirOpcion(){
        Scanner sc = new Scanner(System.in);

        int o = -1;

        System.out.println("Tipo de Agenda.Cifrado : ");
        o = sc.nextInt();

        //Si la opción es incorrecta, imprime un error
        if ( o != 1 && o != 2)
            System.err.println("---------------------\n  Opción incorrecta \n---------------------");
        else
            //Si no, si la opción es 1, el cifrado es XOR y si es 2 CESAR
            if (o == 1)
                tipoCifrado = "XOR";
            else
                tipoCifrado = "CESAR";

    }

    /** Método mostrarMenu : muestra el menú con las opciones que puede elegir el usuario*/
    public void mostrarMenu(){

        System.out.println(
                "1. Agenda.Cifrado XOR\n" +
                "2. Agenda.Cifrado Cesar\n");
    }


    public String getTipoCifrado() {
        return tipoCifrado;
    }
}
