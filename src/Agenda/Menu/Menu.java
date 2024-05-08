package Agenda.Menu;

import java.util.Arrays;

/**
 ************************
 * Clase : Menu
 * Autor : Alejandro Gálvez Madueño
 * Fecha : 04/2024
 * Version : 0.0
 * Testeo : No
 * Descripción : Clase abstracta que obliga a los hijos a implementar los métodos para mostrar el menú y pedir una opción
 ************************
 * */
public abstract class Menu {


    /**Metodos abstractos que tienen que implementar los menus hijos **/

    /**mostrarMenu : Muestra las opciones por pantalla del menú **/
    public abstract void mostrarMenu();

    /**pedirOpcion : Pide la opción del menú **/
    public abstract void pedirOpcion();

}
