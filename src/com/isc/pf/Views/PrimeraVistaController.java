package com.isc.pf.Views;

import com.isc.pf.Main;
import com.isc.pf.models.Maestro;
import com.sun.corba.se.pept.transport.Connection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Created by Marina on 09/05/2017.
 */
public class PrimeraVistaController {

    @FXML
    private TextField txtMatricula;
    @FXML
    private Label status;

    // Variables de conexion
    private String url = "jdbc:postgresql://localhost/proyectoFInal";
    private String us="postgres";
    private String pass="a123";

    // Objeto clase conexionMySQL e instanciar clase
    private SQLConnection conexion = new SQLConnection();


    @FXML
    public void iniciar(){
        int matricula=0;
        matricula=Integer.parseInt(txtMatricula.getText());

        /*
         Aqui se validara la matricula y dependiendo de cual sea ya sea de Maestro, alumno, administrador
         sera la vista que se mostrara en la siguiente pantalla.
        */
    }
    @FXML
    public void btnIniciar() throws SQLException{

        try{
            boolean noesta=true;
            Class.forName("org.postgresql.Driver");
            java.sql.Connection con=
                    DriverManager.getConnection("jdbc:postgresql://localhost/proyectoFInal","postgres","a123");
            Statement estado= con.createStatement();
            ResultSet resultado=estado.executeQuery("SELECT*FROM usuario WHERE matricula='"+ txtMatricula.getText()+"'");
//EXPORTAR EL RESULTADO
            while(resultado.next()){
                if(txtMatricula.getText().length()==4) {
                    if(resultado.getString("matricula").equals(txtMatricula.getText())){
                        Main.iniciaRegistroMaestro(resultado);
                        noesta=false;
                    }else{
                        alerta(txtMatricula.getText());
                    }

                    if (noesta) {
                        alerta(txtMatricula.getText());
                    }

                }
                else if(txtMatricula.getText().length()==3){
                    if(resultado.getString("matricula").equals(txtMatricula.getText())){
                        Main.iniciaRegistroAdmon(resultado);
                        noesta=false;
                    }
                    if (noesta) {
                        alerta(txtMatricula.getText());
                    }
                }
                else if(txtMatricula.getText().length()>=8&&txtMatricula.getText().length()<13){
                    if(resultado.getString("matricula").equals(txtMatricula.getText())){
                       // Main.iniciaRegistroAdmon(resultado);
                        System.out.println("Si esta");
                        noesta=false;
                    }
                    if (noesta) {
                        alerta(txtMatricula.getText());
                    }

                }else {
                    if (noesta) {
                        alerta(txtMatricula.getText());
                    }
                }
            }

        }catch(SQLException ex){
            System.out.println("Error de MySQL");System.out.println(ex.getMessage());
        }catch(ClassNotFoundException err){
            err.printStackTrace();
        }catch(Exception err){
            System.out.println("Se ha encontrado un error inesperado, que es: "+err.getMessage());
        }

        txtMatricula.setText("");
    }



    public static void alerta(String mat){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("MATRICULA NO ENCONTRADA");
        alert.setContentText("La matricula "+mat+" no se ha encontrado \nen el registro de la Base de datos.");

        alert.show();
    }


}
