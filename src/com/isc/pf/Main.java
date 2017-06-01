package com.isc.pf;

import com.isc.pf.Views.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main extends Application {
    static Stage myStage;


    private String url = "jdbc:postgresql://localhost/proyectoFInal";
    private String us="postgres";
    private String pass="a123";

    // Objeto clase conexionMySQL e instanciar clase
    private SQLConnection conexion = new SQLConnection();


    public Main(){
        conexion.crearConexion(url, us, pass,false);

    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        /*Parent root = FXMLLoader.load(getClass().getResource("Views/PrimeraVista.fxml"));
        primaryStage.setTitle("CONTROL DE CENTRO DE COMPUTO");
        vistaRegistroMaestroController controller=loader.getController();
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();*/
        iniciar();
    }


    public static void iniciar(){
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("Views/PrimeraVista.fxml"));
        AnchorPane ancontactos= null;
        try {
            ancontactos = (AnchorPane) loader.load();
            Stage dialogo=new Stage();
            PrimeraVistaController controller=loader.getController();
            controller.setStageDialogo2(dialogo);
            dialogo.setTitle("CONTROL DE CENTRO DE COMPUTO");
            dialogo.initModality(Modality.WINDOW_MODAL);
            dialogo.initOwner(myStage);
            Scene escena=new Scene(ancontactos);
            dialogo.setScene(escena);
            //prestamoSalaController inicia=loader.getController();
            //inicia.llenarTabla("SELECT * FROM prestamoSala ORDER BY disponibilidad");
            dialogo.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void iniciaRegistroMaestro(ResultSet consulta) throws SQLException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("Views/VistaRegistroMaestro.fxml"));
        AnchorPane ancontactos= null;
        try {
            ancontactos = (AnchorPane) loader.load();
            Stage dialogo=new Stage();
            vistaRegistroMaestroController controller=loader.getController();
            controller.setStageDialog(dialogo);
            dialogo.setTitle("REGISTRO DE MAESTRO");
            dialogo.initModality(Modality.WINDOW_MODAL);
            dialogo.initOwner(myStage);
            Scene escena=new Scene(ancontactos);
            dialogo.setScene(escena);
            controller.detallesContacto(consulta);
            //prestamoSalaController inicia=loader.getController();
            //inicia.llenarTabla("SELECT * FROM prestamoSala ORDER BY disponibilidad");
            dialogo.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void iniciaRegistroAdmon(ResultSet consulta) throws SQLException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("Views/RegistroAdmin.fxml"));

        AnchorPane ancontactos= null;
        try {
            ancontactos = (AnchorPane) loader.load();
            Stage dialogo=new Stage();
            RegistroAdminController controller=loader.getController();
            controller.setStageDialog(dialogo);
            dialogo.setTitle("REGISTRO DE ADMINISTRADOR");
            dialogo.initModality(Modality.WINDOW_MODAL);
            dialogo.initOwner(myStage);
            Scene escena=new Scene(ancontactos);
            dialogo.setScene(escena);
            controller.detallesContacto(consulta);
            dialogo.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void iniciaPrestamoSala(String id) throws SQLException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("Views/prestamoSala.fxml"));
        AnchorPane ancontactos= null;
        try {
            ancontactos = (AnchorPane) loader.load();
            Stage dialogo=new Stage();
            PrestamoSalaController controller=loader.getController();
            controller.setStageDialogo2(dialogo);
            dialogo.setTitle("PRESTAMO SALA");
            dialogo.initModality(Modality.WINDOW_MODAL);
            dialogo.initOwner(myStage);
            Scene escena=new Scene(ancontactos);
            controller.llenarTabla("select s.descripcion, ps.horae, ps.horas,ps.fecha from sala s inner join prestamoSala ps on s.nosala=ps.ns order by ps.fecha, ps.horas");
            controller.obtenerId(id);
            dialogo.setScene(escena);
            dialogo.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void iniciaPrestamoPc(String mats) throws SQLException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("Views/VistaPrestamoPC.fxml"));
        AnchorPane ancontactos= null;
        try {
            ancontactos = (AnchorPane) loader.load();
            Stage dialogo=new Stage();
            VistaPrestamoPCController controller=loader.getController();
            controller.setStageDialog(dialogo);
            controller.setTitulo(mats);
            controller.detallesContacto("select nopc,disponibilidad from pc order by disponibilidad");
            dialogo.setTitle("PRESTAMO PC");
            dialogo.initModality(Modality.WINDOW_MODAL);
            dialogo.initOwner(myStage);
            Scene escena=new Scene(ancontactos);
            dialogo.setScene(escena);
            dialogo.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
