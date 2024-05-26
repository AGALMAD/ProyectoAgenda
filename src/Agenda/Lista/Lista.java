package Agenda.Lista;

import Agenda.Cifrado.Cifrado;

import java.io.*;
import java.util.ArrayList;

/**
 ************************
 * Clase : Lista
 * Autor : Alejandro Gálvez Madueño y Yon Cortes Bernal
 * Fecha : 05/2024
 * Version : 1.0
 * Testeo :
 * Descripción : Clase de Lista, permite manejar toda la lista de los contactos
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

    /**
     * Método editarContacto
     * inserta el contacto editado en su posición
     * @param contactoEditado
     * @param apodo
     * @return false si no existe el apodo | true si se ha insertado correctamente
     */
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


    /********** Pasar a ficheros binarios sin cifrar (versión anterior)*************/


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
     *
     * @param apodo
     */
    public Contacto consultarContacto(String apodo) {

        if (existeApodo(apodo)) {
            return listaContactos.get(posicionContacto(apodo));
        }

        return null;
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

    /**
     * Método para saber si la lista está vacia
     * @return
     */
    public boolean listaVacia(){
        return listaContactos.isEmpty();
    }




    /************************** Cifrado **************************/


    /**
     * Método pasarListaByte
     * Pasa la lista a array de bytes
     * @param listaContactos
     * @return la lista pasada a array de bytes
     */
    public byte[] pasarListaByte(ArrayList<Contacto> listaContactos) throws IOException {
        //Array que va almacenar la lista en forma de bytes
        byte [] arrayBytes = null;
        //Pasa la lista a bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream objOstream = new ObjectOutputStream(baos);
        objOstream.writeObject(listaContactos);
        objOstream.flush();
        arrayBytes = baos.toByteArray();

        return arrayBytes;
    }

    /**
     * Método pasarByteLista
     * Los bytes ya descifrados los pasa a la lista
     * @param listaByte
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void pasarByteLista(byte[] listaByte) throws IOException, ClassNotFoundException {
        // Convierte el arreglo de bytes de nuevo a una lista de Contactos
        ByteArrayInputStream bais = new ByteArrayInputStream(listaByte);
        ObjectInputStream objIstream = new ObjectInputStream(bais);
        listaContactos = (ArrayList<Contacto>) objIstream.readObject();

    }

    /**
     * Método cifrar
     * Cifra la lista con el método indicado y la pasa al fichero binario
     * @param tipo
     * @param ficheroCifrar
     * @throws IOException
     */
    public void cifrar(String tipo, ObjectOutputStream ficheroCifrar) throws IOException{

        Cifrado cifrado = new Cifrado();
        //Introduce en el fichero el tipo de cifrado implementado y el array de bytes cifrado como un solo objeto
        switch (tipo){
            case "XOR" :{
                //Introduce un número entero en el fichero para posteriormente saber el tipo de cifrado que se ha realizado
                ficheroCifrar.writeInt(1);
                //Pasa al fichero binario, la lista pasada a bytes y cifrada con XOR
                ficheroCifrar.writeObject(cifrado.cifradoXor(pasarListaByte(listaContactos)));
                break;
            }
            case "CESAR":{
                ficheroCifrar.writeInt(2);
                //Pasa al fichero binario, la lista pasada a bytes y cifrada con Cesar
                ficheroCifrar.writeObject(cifrado.cifradoCesar(pasarListaByte(listaContactos)));
                break;
            }

        }
    }


    /**
     * Método descifrarFichero
     * El primer byte del fichero recoge el tipo de cifrado que se ha realizado en el fichero, lo descifra con el método correspondiente
     * @param ficheroCifrado
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void descifrarFichero(ObjectInputStream ficheroCifrado) throws IOException, ClassNotFoundException {

        Cifrado cifrado = new Cifrado();

        int tipo = ficheroCifrado.readInt(); //recoge el tipo de cifrado que se ha implementado
        byte[] listaByte;
        //recoge los datos del fichero binario
        listaByte = (byte[]) ficheroCifrado.readObject();

        //Descifra el array de bytes
        switch (tipo){
            case 1:{
                cifrado.cifradoXor(listaByte);
                break;
            }
            case 2:{
                cifrado.descifradoCesar(listaByte);
                break;
            }
        }

        //pasa el array de bytes a la lista
        pasarByteLista(listaByte);

    }


}
