package Agenda;

import Agenda.Lista.Contacto;
import Agenda.Lista.Datos;
import Agenda.Lista.Lista;
import Agenda.Menu.MenuCifrado;
import Agenda.Menu.MenuPrincipal;
import Agenda.Cifrado.Cifrado;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //Scanner para recoger los datos del usuario
        Scanner sc = new Scanner(System.in);

        /*Intancia de los menus para poder utilizarlos en el programa*/
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        MenuCifrado menuCifrado = new MenuCifrado();

        /* Intancia la lista en la que se van a almacenar los contactos*/
        Lista listaContactos = new Lista();

        /* Intancia de la clase que pide los datos */
        Datos datos = new Datos();
        //Opción que sale del bucle
        final int SALIR = 0;

        //Fichero binario en el que se van a insertar los datos
        String nombreFicheroBinario = "binario.dat";




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
                    //Pide el apodo que se le va a dar al nuevo contacto, si existe, lo vuelve a pedir
                    System.out.println("Apodo que le vas a dar al nuevo contacto");
                    String apodo = sc.nextLine();
                    while (listaContactos.existeApodo(apodo)){
                        System.err.println("El apodo ya existe, introduce uno no existente");
                        apodo = sc.nextLine();
                    }
                    
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
                        System.out.println("Contacto editado correctamente");
                        //Mostramos los datos del contacto editado
                        System.out.println(contactoEditado.toString());
                    }

                    break;
                }
                
                //muestra los datos del contacto buscado por el apodo
                
                case 4:{
                	 // Pedimos el apodo
                    System.out.println("Apodo del contacto a buscar: ");
                    String apodo = sc.nextLine();

                    if (listaContactos.existeApodo(apodo))
                        listaContactos.consultarContacto(apodo);
                    else
                        System.err.println("El contacto no existe");
                    break;
                	
                }
                
                //eliminar un contacto de la lista    
                case 5: {
                    // Pedir al usuario que ingrese el apodo del contacto a eliminar
                    System.out.println("Apodo del contacto a eliminar: ");
                    String apodo = sc.nextLine();
                    
                    if (listaContactos.existeApodo(apodo)) {
                        if (listaContactos.eliminarContacto(apodo))
                            System.out.println("Contacto " + apodo + " eliminado con exito");
                    }
                    else
                        System.err.println("El contacto no existe");

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
                	listaContactos.listarContactos();

                	break;
                }
                //Lista los contactos en fichero de texto
                case 8 : {
                    //Pide el nombre del fichero en el que se van a guardas los contactos
                    System.out.println("Fichero en el que quieres introducir los contactos");
                    String nombreFichero  = sc.nextLine();

                    PrintWriter fichero = null;

                    try {
                        //Crea el fichero con el nombre que le da el usuario
                        fichero = new PrintWriter(new FileWriter(nombreFichero));
                        listaContactos.listarFicheroTexto(fichero);

                    }
                    //Si hay un fallo con el fichero, imprime este
                    catch (IOException e) {
                        System.err.println(e.toString());
                    }
                    //Cierra el fichero cuando termina las acciones con el
                    finally {
                        if (fichero != null)
                            fichero.close();
                    }

                    break;
                }

                default:
                    System.err.println("---------------------\n  Opción incorrecta \n---------------------");
                    break;
            }

        }

        // Cuando termina el programa, introduce la lista en el fichero binario
        ObjectOutputStream ficheroBinario = null;

        try {
            //Abre el fichero en el que se van a introducir los datos
            ficheroBinario = new ObjectOutputStream(new FileOutputStream(nombreFicheroBinario));
            listaContactos.insertarFicheroBinario(ficheroBinario);

        }
        catch (IOException e){
            System.err.println(e.toString());
        }
        finally {
            if (ficheroBinario != null)
                ficheroBinario.close();
        }



    }
}