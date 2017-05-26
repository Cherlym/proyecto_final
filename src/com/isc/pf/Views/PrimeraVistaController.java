package com.isc.pf.Views;

import com.isc.pf.Main;
import com.isc.pf.models.Maestro;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;



/**
 * Created by Marina on 09/05/2017.
 */
public class PrimeraVistaController {
    @FXML
    private TextField txtMatricula;


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
    public void btnIniciar(){
        boolean noesta=true;
      if(txtMatricula.getText().length()<=4) {
            Main.getDatosUsuariosM();
            for(int x=0;x<Main.getDatosUsuariosM().size();x++) {
                if(Main.getDatosUsuariosM().get(x).getMatricula().equals(txtMatricula.getText())){
                    Main.iniciaRegistroMaestro(Main.getDatosUsuariosM().get(x));
                    noesta=false;
                }
            }
          if (noesta) {
              alerta(txtMatricula.getText());
          }

       }
        else if(txtMatricula.getText().length()==3){
            for(int x=0;x<Main.getDatosUsuariosAd().size();x++) {
                if(Main.getDatosUsuariosAd().get(x).getMatricula().equals(txtMatricula.getText())){
                    Main.iniciaRegistroAdmon(Main.getDatosUsuariosAd().get(x));
                    noesta=false;
                }
            }
          if (noesta) {
              alerta(txtMatricula.getText());
          }
        }
        else if(txtMatricula.getText().length()>=8&&txtMatricula.getText().length()<13){
            for(int i=0;i<Main.getDatosUsuariosAl().size();i++) {
                if (Main.getDatosUsuariosAl().get(i).getMatricula().equals(txtMatricula.getText())) {
                    //Main.iniciaRegistroAlumno(Main.getDatosUsuariosAl().get(i));
                    System.out.println("Si esta");
                    noesta = false;
                }
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

    public static void alerta(String mat){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("MATRICULA NO ENCONTRADA");
        alert.setContentText("La matricula "+mat+" no se ha encontrado \nen el registro de la Base de datos.");

        alert.show();
    }


}
