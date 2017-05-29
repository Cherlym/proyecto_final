package com.isc.pf.Views;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by alex_ on 29/05/2017.
 */
public class SQLConnection {

    public static Connection Connector(){

        try {
            String url = "jdbc:postgresql://localhost/proyectoFInal";
            String usuario="postgres";
            String pass="a123";
            Class.forName("org.postgresql.Driver");
            Connection conexion= DriverManager.getConnection(url,usuario,pass);
            return conexion;
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("BASE DE DATOS NO ENCONTRADA");
            alert.setContentText("Error en la conexión con \n la Base de datos");

            alert.show();
            return null;
        }

    }

}
