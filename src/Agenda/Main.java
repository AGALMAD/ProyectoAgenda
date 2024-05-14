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
                    
                    // Caso de insertar nuevo contacto
                case 2: { //Si se ponene {} , es un ámbito diferente y no sale error al crear variables con el mismo nombre
                    //Pide el apodo que se le va a dar al nuevo contacto
                	
                    System.out.println("Apodo que le vas a dar al nuevo contacto");
                    String apodo = sc.nextLine();
                    
                    //Pide los datos restantes en el contacto
                    Contacto nuevoContacto = datos.pedirDatos();
                    nuevoContacto.setApodo(apodo);
                    
                    //Inserta el contacto
                    listaContactos.insertarContacto(nuevoContacto);
                    System.out.println("Contacto agregado correctamente");
                    break;
                }
                	//Caso de editar contacto
                case 3: {
                    //Busca por el apodo el contacto requerido
                    System.out.println("Apodo del contacto a editar: ");
                    String apodo = sc.nextLine();

                    if (!listaContactos.existeApodo(apodo))
                        System.err.println("Contacto no encontrado, imposible editar.");
                    else {
                        //Pide los datos restantes en el contacto
                        Contacto contactoEditado = datos.pedirDatos();
                        contactoEditado.setApodo(apodo);
                        listaContactos.editarContacto(contactoEditado, apodo);
                        System.err.println("Contacto editado correctamente");
                        //Mostramos los datos del contacto editado
                        contactoEditado.toString();
                    }

                    break;
                }
                
                //muestra los datos del contacto buscado por el apodo
                
                case 4:{
                	 // Pedimos el apodo
                    System.out.println("Apodo del contacto a buscar: ");
                    String apodo = sc.nextLine();
                    
                    //utilizo un buscar contacto que devuelva el contacto y lo introduce en contactoBuscado(metodo en clase lista)
                    Contacto contactoBuscado = listaContactos.buscaContacto(apodo);
                    //si es contacto es distinto de null lo ha encontrado
                    if (contactoBuscado != null) {
                        // Mostrar los datos del contacto
                        System.out.println(contactoBuscado.toString());
                    } else {
                        System.err.println("Contacto no encontrado.");
                    }
                    break;
                	
                }
                
                //eliminar un contacto de la lista    
                case 5: {
                    // Pedir al usuario que ingrese el apodo del contacto a eliminar
                    System.out.println("Apodo del contacto a eliminar: ");
                    String apodo = sc.nextLine();
                    
                    //utilizo un buscar contacto que devuelva el contacto y lo introduce en contactoBuscado(metodo en clase lista)
                    Contacto contactoBuscado = listaContactos.buscaContacto(apodo);
                    //si es contacto es distinto de null lo ha encontrado
                    if (contactoBuscado != null) {
                        // Eliminamos el contacto
                        listaContactos.eliminaContacto(contactoBuscado);
                    } else {
                        System.err.println("Contacto no encontrado.");
                    }
                    break;
                }
                
                //Obtiene el numero de contactos de la lista
                case 6:{
                	int contador = listaContactos.numeroContactos();
                	
                	if(contador == 0) {
                		System.out.println("Esta agenda esta vacía.");
                	}else {
                		System.out.println("Numero de contactos: " + contador);
                	}
                	break;
                }
                
                //Muestra todos los contactos de la lista
                case 7:{
                	for(int i=0; i< listaContactos.numeroContactos();i++) {
                		System.out.println(listaContactos.get(i).toString());
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