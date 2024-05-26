
/**
 ************************
 * Clase : ListaTest
 * Autor : Yon Cortes Bernal
 * Fecha : 05/2024
 * Version : 0.0
 * Testeo : No
 * Descripción : Testeo de algunos metodos de la clase lista
 ************************
 */

package Agenda.Pruebas;

/*Lista de librerias importadas necesarias*/


import java.io.*;
import java.time.LocalDate;


import Agenda.Lista.Contacto;
import Agenda.Lista.Lista;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;


class ListaTest {
	/*Creamos un atributo lista de  tipo Lista muy util ya que va a ser necesario para todos los metodos*/
    private Lista lista;

    /*Creamos un metodo que inicialice nuestro atributo en cada metodo para no sobreescribir tanto codigo*/
    @BeforeEach
    void inicializaLista() {
        lista = new Lista();
    }
    
    /*Metodo que prueba el funcionamiento de insertar contacto en la lista*/
    /*Devuelve true o false en funcion si ha realizado correctamente la insercion*/
    @Test
    void testInsertarContacto() {
        Contacto c = new Contacto();
        Assertions.assertTrue(lista.insertarContacto(c));
    }

    
    /*Metodo que prueba el funcionamiento buscar un contacto por el apodo*/
    /*Devuleve true o false si lo ha realizado la busqueda correctamente*/
    @Test
    void testExisteApodo() {
        Contacto c = new Contacto();
        String apodo = "apodo";
        c.setApodo(apodo);
        lista.insertarContacto(c);

        Assertions.assertTrue(lista.existeApodo(apodo));
    }
    
    /*
     * Metodo que verifica si el metodo 'listarFicheroTexto de la clase 'Lista'
    	es capaz de listar correctamente los contactos en formato de texto y generar la salida esperada
     */

    @Test
    void testListarFicheroTexto() {
        // Creamos algunos contactos de prueba
        Contacto contacto1 = new Contacto("Juan", "gonzalez", LocalDate.of(1993, 2, 11), 123456789, "juan.gonzalez@gmail.com", "Juanito");
        Contacto contacto2 = new Contacto("ana", "cortes", LocalDate.of(1995, 8, 22), 987654321, "ana.cortes@hotmail.com", "anita");

        // Los agregamos a la lista
        lista.insertarContacto(contacto1);
        lista.insertarContacto(contacto2);

        // Redirigimos la salida a un StringWriter para capturar la salida
        StringWriter contenedor = new StringWriter();
        PrintWriter contenido = new PrintWriter(contenedor);

        // Ejecutamos el método que queremos probar
        lista.listarFicheroTexto(contenido);

        // Aseguramos que el PrintWriter ha terminado de escribir
        contenido.flush();

        // Verificamos si el contenido es correcto
        String resultado = contacto1.toString() + contacto2.toString() ;
        Assertions.assertEquals(resultado, contenedor.toString());
    }


    

    /* Metodo que comprueba si el metodo consultarContacto de la clase Lista puede recuperar 
     * correctamente un contacto por su apodo
     */

    @Test
    void testConsultarContacto() {
    	 Contacto c = new Contacto("Juan", "gonzalez", LocalDate.of(1993, 2, 11), 123456789, "juan.gonzalez@gmail.com", "Juanito");
        lista.insertarContacto(c);

        Contacto consultado = lista.consultarContacto("Juanito");
        Assertions.assertNotNull(consultado);
        Assertions.assertEquals("Juanito", consultado.getApodo());
    }

    /*
     * Metodo que comprueba que el metodo eliminar contacto funcione,
     *  para ello verificamos al final que el apodo del contacto ya eliminado no exista
     */
    @Test
    void testEliminarContacto() {
        Contacto c = new Contacto();
        String apodo = "apodo";
        c.setApodo(apodo);
        lista.insertarContacto(c);

        Assertions.assertTrue(lista.eliminarContacto(apodo));
        Assertions.assertFalse(lista.existeApodo(apodo));
    }
}
