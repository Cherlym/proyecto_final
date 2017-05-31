package com.isc.pf.Views;

import java.sql.*;
import javax.swing.*;


public class SQLConnection {
    private static Connection conexion;

    public boolean crearConexion(String url, String us, String pass, boolean veriConexion){
        // Variable de tipo Connection

        try{
            // Se establece la conexión con el servidor solicitando los datos
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url,us,pass);

            // Opcionalmente se puede mostrar un mensaje para verificar que la conexión funciono (poniendo en true el ultimo parametro)
            if(veriConexion == true){
                JOptionPane.showMessageDialog(null, "Se ha realizado la conexión con éxito!","MySQL en " + url,JOptionPane.INFORMATION_MESSAGE);
            }
            return true;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Se ha producido el siguiente error: " + e.getMessage(),"Erro al conectar " + url,JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public Connection obtenerConexion(){
        return conexion;
    }

    public ResultSet ejecutarConsulta(String SQL){
        try{
            Statement estado = conexion.createStatement();
            ResultSet resultado = estado.executeQuery(SQL);
            return resultado;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage(), "Error de consulta SQL", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public Statement actualizarRegistro(String SQL){
        try{
            Statement estado = conexion.createStatement();
            estado.executeUpdate(SQL);
            return estado;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage(), "Error de consulta SQL", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public boolean cerrarConexion(){
        try{
            conexion.close();
            return true;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error al cerrar la conexión: " + e.getMessage(), "Error al cerrar la conexión", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
