package Agenda;

import Agenda.Lista.Contacto;
import Agenda.Lista.Datos;
import Agenda.Lista.Lista;
import Agenda.Menu.MenuCifrado;
import Agenda.Menu.MenuPrincipal;
import Agenda.Cifrado.Cifrado;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //Scanner para recoger los datos del usuario
        Scanner sc = new Scanner(System.in);
        
        /*Constante de clave en cifrado*/
       
        /*Intancia de los menus para poder utilizarlos en el programa*/
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        MenuCifrado menuCifrado = new MenuCifrado();

        /* Intancia la lista en la que se van a almacenar los contactos*/
        Lista listaContactos = new Lista();

        /* Intancia de la clase que pide los datos */
        Datos datos = new Datos();

        //Fichero binario en el que se van a insertar los datos
        String nombreFicheroBinario = "./binario.dat"; //Si no se especifica la ruta, salta una excepción

        //Fichero binario
        ObjectInputStream ficheroBinarioLeer = null;

        //Cifrado que va a terner por defecto es el cifrado XOR
        Cifrado cifrado = new Cifrado();


        //Intenta recoger los datos del fichero binario, si no existe, sigue con el programa
        try {
            ficheroBinarioLeer = new ObjectInputStream(new FileInputStream(nombreFicheroBinario));
            listaContactos.descifrarFichero(ficheroBinarioLeer);

        }
        //Si llega al final del fichero o no está creado, ignora la salida
        catch (EOFException | FileNotFoundException ignored){}
        catch (IOException e){
            System.err.println("Error al recoger los datos del fichero");
        }
        catch (ClassNotFoundException e){
            System.err.println(e.toString());
        }
        finally {
            if (ficheroBinarioLeer != null)
                ficheroBinarioLeer.close();
        }


        /***
         * Bucle que estará pidiendo opciones hasta que introduzca la opción salir
         */
        //Opción que sale del bucle
        final int SALIR = 0;
        while (menuPrincipal.getOpcion() != SALIR) {

            menuPrincipal.mostrarMenu();
            //Si introduce otro caracter que no sea un número, no termina el programa
            try {
                menuPrincipal.pedirOpcion();
            }
            catch (InputMismatchException e){
                System.err.println("Solo se pueden introducir números");
            }

            switch (menuPrincipal.getOpcion()){
                case 0:
                    System.out.println("---------------------\n  FIN DEL PROGRAMA \n---------------------");
                    break;
                case 1:
                    menuCifrado.mostrarMenu();
                    //Si introduce otro caracter que no sea un número, no termina el programa
                    try {
                        menuCifrado.pedirOpcion();
                    }
                    catch (InputMismatchException e){
                        System.err.println("Solo se pueden introducir números");
                    }
                    System.out.println("Cifrado elegido : " + menuCifrado.getTipoCifrado());

                    
                    break;
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
                    System.out.println(listaContactos.insertarContacto(nuevoContacto) ? "Contacto agregado correctamente" : "ERROR || no se puede insertar el contacto");

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
                        System.out.println(listaContactos.editarContacto(contactoEditado, apodo) ? "Contacto editado correctamente": "ERROR || no se puede editar el contacto");
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
                        System.out.println(listaContactos.consultarContacto(apodo).toString());
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



        //Si la lista tiene contenido, la guarda en el fichero binario
        if (!listaContactos.listaVacia()) {
            // Cuando termina el programa, introduce la lista en el fichero binario
            ObjectOutputStream ficheroBinarioEscribir = null;

            try {
                //Abre el fichero en el que se van a introducir los datos
                ficheroBinarioEscribir = new ObjectOutputStream(new FileOutputStream(nombreFicheroBinario));
                listaContactos.cifrar(menuCifrado.getTipoCifrado(),ficheroBinarioEscribir);


            } catch (IOException e) {
                System.err.println(e.toString());
            } finally {
                if (ficheroBinarioEscribir != null)
                    ficheroBinarioEscribir.close();
            }

        }

    }
}