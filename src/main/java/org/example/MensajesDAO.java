package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {

    public static  void crearMensajeDB (Mensajes mensaje){
        Conexion db_connect = new Conexion();

        try( Connection conexion = db_connect.get_connection() ) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO message ( message, author_message ) VALUES ( ?, ?)";
                ps = conexion.prepareStatement( query );

                ps.setString(1, mensaje.getMensaje() );
                ps.setString(2, mensaje.getAutor_mensaje());

                ps.executeUpdate();
                System.out.println("Mensaje creado");

            }catch ( SQLException ex ){
                System.out.println( ex );
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void leerMensajesDB(){
        Conexion db_connect = new Conexion();

        try( Connection conexion = db_connect.get_connection() ) {
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                String query = "SELECT * FROM message";
                ps = conexion.prepareStatement( query );
                rs = ps.executeQuery();

                while( rs.next() ){
                    System.out.println( "ID: " + rs.getInt(("id_message")));
                    System.out.println("Mensaje: "  + rs.getString("message"));
                    System.out.println("Autor: " + rs.getString("author_message"));
                    System.out.println("Fecha: " + rs.getString("date_message" ));
                    System.out.println("");
                }

            }catch ( SQLException ex ){
                System.out.println( ex );
            }

        }catch ( SQLException e){
            System.out.println("No se pudo sacar los mensajes");
            System.out.println(e);
        }
    }

    public static void borrarMensajeDB( int id_mensaje ){
        Conexion db_connect = new Conexion();

        try( Connection conexion = db_connect.get_connection() ) {
            PreparedStatement ps = null;

            try{
                String query = "DELETE FROM message WHERE id_message = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("Mensaje borrado");

            }catch (SQLException ex){
                System.out.println(ex);
                System.out.println("No se pudo borrar el mensaje");
            }

        }catch ( SQLException e){
            System.out.println(e);
        }

    }

    public static void actualizarMensajeDB( Mensajes mensaje ){

        Conexion db_connect = new Conexion();

        try( Connection conexion = db_connect.get_connection() ) {
            PreparedStatement ps = null;

            try{
                String query = "UPDATE message SET message = ? WHERE id_message = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje actualizado correctamente");
            }catch (SQLException ex){
                System.out.println("Mensaje no se ha podico actualizar");
                System.out.println(ex);
            }

        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
