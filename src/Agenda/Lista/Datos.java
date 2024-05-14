package Agenda.Lista;

import java.util.Date;
import java.util.Scanner;

public class Datos {

    Scanner sc = new Scanner(System.in);

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
        String numero;
        do{
            System.out.println("Número de telefono");
            num = sc.next();
        }while(num.length()!=9 || !serNumero(num));
        System.out.println("Número válido: " + num);
        

        //Limpia el buffer
        sc.nextLine();

        //Pide el mail
        System.out.println("Mail");
        String mail = sc.nextLine();
        //cierra el sc
        sc.close();
        

        //Retorna el contacto con todos los datos menos el apodo
        return new Contacto(nombre,apellidos,fnac,num,mail);
    }

    // Comprueba que la cadena solo tenga digitos
    public static boolean serNumero(String cadena) {
        if (cadena == null) {
            return false;
        }
        for (char c : cadena.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }


}

