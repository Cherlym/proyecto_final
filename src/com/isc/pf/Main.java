package com.isc.pf;

import com.isc.pf.Views.RegistroAdminController;
import com.isc.pf.Views.vistaRegistroMaestroController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    static Stage myStage;

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
    public static void iniciaRegistroMaestro(){
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
            dialogo.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void iniciaPrestamoSala(){

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

    public static void iniciaPrestamoAdmin(){
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("Views/RegistroAdmin.fxml"));
        AnchorPane ancontactos=null;

        try {
            ancontactos=(AnchorPane)loader.load();
            Stage dialogo=new Stage();
            RegistroAdminController controlador=loader.getController();
            dialogo.setTitle("Prestamo Administrador");
            dialogo.initModality(Modality.WINDOW_MODAL);
            dialogo.initOwner(myStage);
            Scene scene=new Scene(ancontactos);
            dialogo.setScene(scene);
            dialogo.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
