package Agenda.Lista;

import java.io.*;
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

    /*********************** Atributos ***********************/

    /** Atributo listaContactos
     * Almacena la lista de todos los contactos
     */
    private ArrayList<Contacto> listaContactos;

    /*********************** Constructores ***********************/

    /** Constructor por defecto de la lista, crea la lista y la inicializa todo a null */
    public Lista(){

        listaContactos = new ArrayList<Contacto>();

    }


    /*********************** MÉTODOS ***********************/

    /**
     * insertarContacto
     * Se le pasa un contacto y se inserta en la lista
     * @param nuevoContacto
     */
    public boolean insertarContacto( Contacto nuevoContacto){

        return listaContactos.add(nuevoContacto);

    }


    public boolean editarContacto(Contacto contactoEditado, String apodo){

        //Si el apodo no existe, no sigue con el programa
        if (!existeApodo(apodo))
            return false;


        int pos = posicionContacto(apodo);

        try {
            listaContactos.set(pos,contactoEditado);
            return true;
        }
        catch (Exception e) {
            throw e;
        }

    }


    /**
     * Método que comprueba si el contacto existe
     * @param apodo
     * @return true si existe, false si no existe
     */
    public boolean existeApodo( String apodo){
        for (Contacto c : listaContactos){
            if (c.getApodo().equalsIgnoreCase(apodo))
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
     * Método listarFicheroTexto
     * Introduce todos los contactos dentro del fichero de texto
     * @param fichero
     */
    public void listarFicheroTexto(PrintWriter fichero){
        for (Contacto c : listaContactos){
            fichero.println(c.toString());
        }
    }


    /**
     * Método insertarFicheroBinario
     * Introduce la lista en el fichero binario
     * @param fichero fichero binario en el que se van a introducir los datos
     * @throws IOException si hay algún fallo, retorna una excepción
     */
    public void insertarFicheroBinario(ObjectOutputStream fichero) throws IOException {

        //Inserta la lista en el fichero Binario
        for (Contacto c : listaContactos){
            fichero.writeObject(c);
        }

    }

    /**
     * Método recogerFicheroBinario
     * Se pasa el fichero binario e inserta los datos de este en la lista
     * @param ficheroBinario
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void recogerFicheroBinario(ObjectInputStream ficheroBinario) throws IOException, ClassNotFoundException, EOFException {

        Contacto nuevoContacto = null;
        nuevoContacto = (Contacto) ficheroBinario.readObject();

        while (nuevoContacto != null){
            listaContactos.add(nuevoContacto);
            nuevoContacto = (Contacto) ficheroBinario.readObject();

        }

    }


    /**
     * consultarContacto
     * Si existe el contacto, lo imprime por pantalla, si no, imprime que ese contacto no existe
     * @param apodo
     */
    public boolean consultarContacto(String apodo) {

        if (existeApodo(apodo)) {
            System.out.println(listaContactos.get(posicionContacto(apodo)).toString());
            return true;
        }

        return false;
    }


    /**
     * Método eliminarContacto
     * Elimina el contacto de la lista si el apodo existe
     * @param apodo
     * @return
     */
    public boolean eliminarContacto(String apodo) {
        int posicion = posicionContacto(apodo); // Obtiene la posición del contacto con el apodo que le pasamos
        if (posicion != -1) {
            listaContactos.remove(posicion); // Elimina el contacto 
            return true; // Indica que el contacto fue eliminado con éxito, el mensaje lo damos en el main
        }
        return false; // En caso de no haberlo encontrado
    }

    /**
     * posicionContacto
     * Busca el apodo del contacto y si lo encuentra, devuelve la posición de este
     * @param apodo
     * @return posicion
     */
    private int posicionContacto(String apodo) {
        // Recorremos la lista en busca de un apodo que sea igual que el String pasado
        for (int i = 0; i < listaContactos.size(); i++) {
            // Si encuentra el apodo, devuelve la posición de este
            if (listaContactos.get(i).getApodo().equalsIgnoreCase(apodo))
                return i;
        }
        return -1; // Devueve -1 si no se encuentra el apodo en nuestra lista
    }

    /**
     * Método numeroContactos
     * Retorna el número de contactos que contiene la lista
     * @return
     */
    public int numeroContactos() {
    	return listaContactos.size();
    }


    public boolean listaVacia(){
        return listaContactos.isEmpty();
    }
    

}
