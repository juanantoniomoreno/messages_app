package org.example;

import java.util.Scanner;

public class MensajesService {

    public static void crearMensaje(){
        Scanner sc = new Scanner( System.in );

        System.out.println("Escribe el mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Tu nombre");
        String nombre = sc.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje( mensaje );
        registro.setAutor_mensaje( nombre ) ;

        MensajesDAO.crearMensajeDB(registro);

    }

    public static void listarMensajes(){
        MensajesDAO.leerMensajesDB();
    }

    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el id del mensaje: ");
        int id_message = sc.nextInt();
        MensajesDAO.borrarMensajeDB(id_message);
    }

    public static void editarMensaje(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nuevo mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Introduce el id del mensaje: ");
        int id_message = sc.nextInt();

        Mensajes actualizacion = new Mensajes();
        actualizacion.setMensaje(mensaje);
        actualizacion.setId_mensaje(id_message);

        MensajesDAO.actualizarMensajeDB( actualizacion );

    }
}
