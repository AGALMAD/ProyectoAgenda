package Agenda.Cifrado;

// Define el paquete donde se encuentra esta clase.

import Agenda.Lista.Contacto;

import java.io.ObjectOutputStream;
import java.util.ArrayList;

// La clase Cesar extiende de la clase abstracta Cifrado.
public class Cesar extends Cifrado {


    // Constructor vacío para la clase Cesar.
    public Cesar(int clave) {
        super(clave);
    }

    // Implementación del método cifrar de la clase base.
    public void cifrar(ArrayList<Contacto> listaContactos, ObjectOutputStream fichero) {



    }

    // Implementación del método descifrar de la clase base.
    public void descifrarCesar(String texto, int clave) {


    }


}
