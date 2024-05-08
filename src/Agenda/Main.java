package Agenda;

import Agenda.Menu.Menu;
import Agenda.Menu.MenuCifrado;
import Agenda.Menu.MenuPrincipal;
import Cifrado.Cifrado;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*Intancia de los menus para poder utilizarlos en el programa*/
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        MenuCifrado menuCifrado = new MenuCifrado();

        final int SALIR = 0;

        /***
         * Bucle que estará pidiendo opciones hasta que introduzca la opción salir
         */
        while (menuPrincipal.getOpcion() != SALIR) {

            menuPrincipal.mostrarMenu();
            menuPrincipal.pedirOpcion();

            switch (menuPrincipal.getOpcion()){
                case 0:
                    System.out.println("---------------------\n  FIN DEL PROGRAMA \n---------------------");
                    break;
                case 1:
                    menuCifrado.mostrarMenu();
                    menuCifrado.pedirOpcion();
                    Cifrado cifrado = new Cifrado(menuCifrado.getTipoCifrado());
                    System.out.println(cifrado.getTipoCifrado());
                    break;

                default:
                    System.err.println("---------------------\n  Opción incorrecta \n---------------------");
                    break;
            }



        }
    }
}