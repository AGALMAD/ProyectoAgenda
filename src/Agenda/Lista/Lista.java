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

    public int posicionContacto(String apodo) {

        //Recorre la lista en busca de la posicion del contacto
        for (int i = 0; i < listaContactos.size(); i++) {

            //Si encuentra el apodo, retorna la posición de este
            if (listaContactos.get(i).getApodo().equals(apodo))
                return i;

        }


        return -1;
    }



}
