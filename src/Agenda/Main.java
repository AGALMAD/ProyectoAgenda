package Agenda;

import Agenda.Lista.Contacto;
import Agenda.Lista.Datos;
import Agenda.Lista.Lista;
import Agenda.Menu.MenuCifrado;
import Agenda.Menu.MenuPrincipal;
import Agenda.Cifrado.Cifrado;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*Intancia de los menus para poder utilizarlos en el programa*/
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        MenuCifrado menuCifrado = new MenuCifrado();

        /* Intancia la lista en la que se van a almacenar los contactos*/
        Lista listaContactos = new Lista();

        /* Intancia de la clase que pide los datos */
        Datos datos = new Datos();

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
                case 2: { //Si se ponene {} , es un ámbito diferente y no sale error al crear variables con el mismo nombre
                    //Pide el apodo que se le va a dar al nuevo contacto
                    System.out.println("Apodo que le vas a dar al nuevo contacto");
                    String apodo = sc.nextLine();
                    //Pide los datos restantes en el contacto
                    Contacto nuevoContacto = datos.pedirDatos();
                    nuevoContacto.setApodo(apodo);

                    listaContactos.insertarContacto(nuevoContacto);

                    break;
                }
                case 3: {
                    //Pide el apodo que se le va a dar al nuevo contacto
                    System.out.println("Apodo que le vas a dar al nuevo contacto");
                    String apodo = sc.nextLine();

                    if (!listaContactos.existeApodo(apodo))
                        System.err.println("ERROR | el contacto no existe");
                    else {
                        //Pide los datos restantes en el contacto
                        Contacto contactoEditado = datos.pedirDatos();
                        contactoEditado.setApodo(apodo);

                        listaContactos.editarContacto(contactoEditado, apodo);
                    }


                    break;
                }
                default:
                    System.err.println("---------------------\n  Opción incorrecta \n---------------------");
                    break;
            }



        }
    }
}