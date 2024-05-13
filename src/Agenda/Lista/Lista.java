package Agenda.Lista;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.Scanner;

/**
 ************************
 * Clase : Agenda.Lista
 * Autor : Alejandro Gálvez Madueño
 * Fecha : 05/2024
 * Version : 0.0
 * Testeo : No
 * Descripción : Clase de cifrado
 ************************
 * */

public class Lista {

    /**
     * Atributo */
    private ArrayList<Contacto> listaContactos;

    /** Constructor por defecto de la lista, crea la lista y la inicializa todo a null */
    public Lista(){

        listaContactos = new ArrayList<Contacto>();

    }

    //Constante que almacena el número de contactos que tiene la agenda
    private final int numeroContactos = 25;
    private final Scanner sc = new Scanner(System.in);


    /**
     * Método : pedirDatos
     * Pide todos los datos del contacto menos el apodo al usuario y retorna el contacto,
     * se crea para poder utilizarlo en insertar un nuevo contacto y en modificar contacto
     * @return
     */
    public Contacto pedirDatos(){

        //Pide el nombre
        System.out.println("Nombre : ");
        String nombre = sc.nextLine();

        //Pide los apellidos
        System.out.println("Apellidos");
        String apellidos = sc.nextLine();

        //Pide la fecha de nacimiento como enteros y crea un objeto tipo DATE
        System.out.println("Inserta la fecha de nacimiento");

        int anio = 2000 ,dia = 1,mes = 1;
        Date fnac;

        try {
            System.out.println("\tAño");
            anio = sc.nextInt();
            System.out.println("\tMes");
            mes = sc.nextInt();
            System.out.println("\tdia");
            dia = sc.nextInt();

            if (mes < 1 || mes > 12)
                throw new ArithmeticException("ERROR | mes incorrecto");
            if (dia < 1 || dia > 31)
                throw new ArithmeticException("ERROR | dia incorrecto");
            if (anio < 0)
                throw new ArithmeticException("ERROR | año incorrecto");

            fnac = new Date(anio, mes, dia);

        }
        catch (Exception e){

            // Si ha ocurrido algún fallo en la inserción de la fecha, introduce una fecha por defecto
            System.out.println(e.toString());
            fnac = new Date(2000,1,1);

        }

        //Pide el número
        System.out.println("Número de telefono");
        int num = sc.nextInt();

        //Limpia el buffer
        sc.nextLine();

        //Pide el mail
        System.out.println("Mail");
        String mail = sc.nextLine();

        //Retorna el contacto con todos los datos menos el apodo
        return new Contacto(nombre,apellidos,fnac,num,mail);
    }



    /**
     * nuevoContacto
     * Metodo que se utiliza para pedir un nuevo contacto, pide el apodo y llama a pedirDatos para pedir los datos restantes
     * inserta el nuevo contacto en la lista
     */
    public void nuevoContacto( ){

        System.out.println("Apodo que le vas a dar al  contacto");
        String apodo = sc.nextLine();

        Contacto nuevoContacto = pedirDatos();
        nuevoContacto.setApodo(apodo);

        insertarContacto(nuevoContacto);
    }

    /**
     * insertarContacto
     * Se le pasa un contacto y se inserta en la lista
     * @param nuevoContacto
     */
    public void insertarContacto( Contacto nuevoContacto){

        listaContactos.add(nuevoContacto);

    }



    /**
     * Método que comprueba si el contacto existe
     * @param apodo
     * @return true si existe, false si no existe
     */
    private boolean existeApodo( String apodo){
        for (Contacto c : listaContactos){
            if (c.getApodo().equals(apodo))
                return true;
        }

        return false;
    }


    /**
     * Método  listarContactos
     * Lista por pantalla todos los contactos que existen en la lista
     */
    public void listarContactos(){
        for (Contacto c : listaContactos){
            System.out.println(c.toString() + "\n");

        }
    }


    /**
     * Método editarContacto
     * Pide el apodo y pide los nuevos datos de ese contacto
     * @param contactos
     */
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


    /**
     *
     * @param contactos
     */
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


    /**
     *
     * @param criterio
     * @param valor
     * @param contactos
     * @return
     */

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



}
