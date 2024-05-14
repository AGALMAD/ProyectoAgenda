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
    public void insertarContacto( Contacto nuevoContacto){

        listaContactos.add(nuevoContacto);

    }


    public boolean editarContacto(Contacto contactoEditado, String apodo){

        //Si el apodo no existe, no sigue con el programa
        if (!existeApodo(apodo))
            return false;


        int pos = posicionContacto(apodo);

        listaContactos.set(pos,contactoEditado);
        return true;

    }


    /**
     * Método que comprueba si el contacto existe
     * @param apodo
     * @return true si existe, false si no existe
     */
    public boolean existeApodo( String apodo){
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
     * @param apodo
     * @return 1 si el contacto no existe | 0 si se ha podido editar el contacto
     */
    public int editarContacto( String apodo) {

        //Si el contacto no existe, imprime un mensaje por pantalla
        if (!existeApodo(apodo)){
            return 1;
        }

        return 0;
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
     * posicionContacto
     * Busca el apodo del contacto y si lo encuentra, devuelve la posición de este
     * @param apodo
     * @return posicion
     */

    public boolean eliminarContacto(String apodo) {
        int posicion = posicionContacto(apodo); // Obtiene la posición del contacto con el apodo que le pasamos
        if (posicion != -1) {
            listaContactos.remove(posicion); // Elimina el contacto 
            return true; // Indica que el contacto fue eliminado con éxito, el mensaje lo damos en el main
        }
        return false; // En caso de no haberlo encontrado
    }

    private int posicionContacto(String apodo) {
        // Recorremos la lista en busca de un apodo que sea igual que el String pasado
        for (int i = 0; i < listaContactos.size(); i++) {
            // Si encuentra el apodo, devuelve la posición de este
            if (listaContactos.get(i).getApodo().equals(apodo))
                return i;
        }
        return -1; // Devueve -1 si no se encuentra el apodo en nuestra lista
    }
    
    public int numeroContactos() {
    	return listaContactos.size();
    }

    	
    //me devuelve la i sin pedir apodo

    public Contacto get(int i) {
        if (i >= 0 && i < listaContactos.size()) {
            return listaContactos.get(i);
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        }
    }
    
    //METODO que devuelve un contacto por el apodo pasado   
    public Contacto buscaContacto(String apodo) {
        for (Contacto contacto : listaContactos) {
            if (contacto.getApodo().equals(apodo)) {
                return contacto;
            }
        }
        return null;
    }
}
