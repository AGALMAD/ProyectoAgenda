package Agenda.Cifrado;

// Define el paquete donde se encuentra esta clase.

import Agenda.Lista.Contacto;

import java.io.ObjectOutputStream;
import java.util.ArrayList;

// La clase Cesar extiende de la clase abstracta Cifrado.
public class Cesar extends Cifrado {

    // Define un atributo de tipo Character para la clave (aunque no se usa en esta clase).
    private char clave;

    // Constructor vacío para la clase Cesar.
    public Cesar(char clave) {
        this.clave = clave;
    }

    // Implementación del método cifrar de la clase base.
    public void cifrar(ArrayList<Contacto> listaContactos, ObjectOutputStream fichero) {



    }

    // Implementación del método descifrar de la clase base.
    public void descifrarCesar(String texto, int clave) {


    }


}
