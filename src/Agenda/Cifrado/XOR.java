package Agenda.Cifrado;

// Define el paquete donde se encuentra esta clase.

import Agenda.Lista.Contacto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import static java.awt.SystemColor.text;

// La clase XOR extiende de la clase abstracta Cifrado.
public class XOR extends Cifrado {

    // Constructor vacío para la clase XOR.
    public XOR() {}

    // Implementación del método cifrar de la clase base.

    public void cifrar(ArrayList<Contacto> listaContactos,ObjectOutputStream fichero, int clave) {





    }

    // Implementación del método descifrar de la clase base.
    public void descifrarXOR(String texto, int clave) {


    }



}