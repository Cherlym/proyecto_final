package com.isc.pf;

import com.isc.pf.Views.RegistroAdminController;
import com.isc.pf.Views.SQLConnection;
import com.isc.pf.Views.prestamoSalaController;
import com.isc.pf.Views.vistaRegistroMaestroController;
import com.isc.pf.models.Administrador;
import com.isc.pf.models.Alumno;
import com.isc.pf.models.Maestro;
import com.isc.pf.models.Usuario;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main extends Application {
    static Stage myStage;

    private static ObservableList<Maestro> datosUsuariosM = FXCollections.observableArrayList();
    private static ObservableList<Administrador> datosUsuariosAd = FXCollections.observableArrayList();
    private static ObservableList<Alumno> datosUsuariosAl = FXCollections.observableArrayList();
    private static Connection connection;
    // Variables de conexion
    private String url = "jdbc:postgresql://localhost/proyectoFInal";
    private String us="postgres";
    private String pass="a123";

    // Objeto clase conexionMySQL e instanciar clase
    private SQLConnection conexion = new SQLConnection();


    public Main(){
        conexion.crearConexion(url, us, pass,false);
        datosUsuariosAl.add(new Alumno(001,"Cheno","Hector Alejandro","15050015","Guerrero","ISC",4));
        datosUsuariosAl.add(new Alumno(002,"15050010","Carlos Alberto","Hurtado","Dominguez","ADMN",6));
        datosUsuariosM.add(new Maestro(005,"Ponce","Mendoza","Ulises","0015","Ingenieria y Tecnologias"));
        datosUsuariosAd.add(new Administrador(003,"Vindiola","Gonzalez","009","Alma","Intendencia"));
        datosUsuariosAl.add(new Alumno(004,"15050019","Carlos Miguel","Barceló","Fimbres","ING",2));
    }
    public static ObservableList<Maestro> getDatosUsuariosM(){
        return datosUsuariosM;
    }
    public static ObservableList<Administrador> getDatosUsuariosAd(){
        return datosUsuariosAd;
    }
    public static ObservableList<Alumno> getDatosUsuariosAl(){return datosUsuariosAl;}

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Views/PrimeraVista.fxml"));
        primaryStage.setTitle("CONTROL DE CENTRO DE COMPUTO");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
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
            //controller.setStageDialog(dialogo);
            dialogo.setTitle("REGISTRO DE MAESTRO");
            dialogo.initModality(Modality.WINDOW_MODAL);
            dialogo.initOwner(myStage);
            Scene escena=new Scene(ancontactos);
            dialogo.setScene(escena);
            controller.detallesContacto(consulta);
            //prestamoSalaController inicia=loader.getController();
            //inicia.llenarTabla("SELECT * FROM prestamoSala ORDER BY disponibilidad");
            dialogo.showAndWait();
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
            //controller.setStageDialog(dialogo);
            dialogo.setTitle("REGISTRO DE ADMINISTRADOR");
            dialogo.initModality(Modality.WINDOW_MODAL);
            dialogo.initOwner(myStage);
            Scene escena=new Scene(ancontactos);
            dialogo.setScene(escena);
            controller.detallesContacto(consulta);
            dialogo.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void iniciaPrestamoSala() throws SQLException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("Views/prestamoSala.fxml"));
        AnchorPane ancontactos= null;
        try {
            ancontactos = (AnchorPane) loader.load();
            Stage dialogo=new Stage();
            prestamoSalaController controller=loader.getController();
            //controller.setStageDialog(dialogo);
            dialogo.setTitle("PRESTAMO SALA");
            dialogo.initModality(Modality.WINDOW_MODAL);
            dialogo.initOwner(myStage);
            Scene escena=new Scene(ancontactos);
            controller.llenarTabla("SELECT * FROM prestamoSala ORDER BY horas");
            dialogo.setScene(escena);
            dialogo.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void iniciaPrestamoPc(){
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("Views/VistaPrestamoPC.fxml"));
        AnchorPane ancontactos= null;
        try {
            ancontactos = (AnchorPane) loader.load();
            Stage dialogo=new Stage();
            vistaRegistroMaestroController controller=loader.getController();
            //controller.setStageDialog(dialogo);
            dialogo.setTitle("PRESTAMO PC");
            dialogo.initModality(Modality.WINDOW_MODAL);
            dialogo.initOwner(myStage);
            Scene escena=new Scene(ancontactos);
            dialogo.setScene(escena);
            dialogo.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
