package com.isc.pf.Views;

import com.isc.pf.Main;
import com.isc.pf.models.Maestro;
import javafx.fxml.FXML;
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
      if(txtMatricula.getText().length()<=4) {
            Main.getDatosUsuariosM();
            for(int x=0;x<Main.getDatosUsuariosM().size();x++) {
                if(Main.getDatosUsuariosM().get(x).getMatricula().equals(txtMatricula.getText())){
                    Main.iniciaRegistroMaestro(Main.getDatosUsuariosM().get(x));
                }
            }

       }
        if(txtMatricula.getText().length()==3){
            for(int x=0;x<Main.getDatosUsuariosAd().size();x++) {
                if(Main.getDatosUsuariosAd().get(x).getMatricula().equals(txtMatricula.getText())){
                    Main.iniciaRegistroAdmon(Main.getDatosUsuariosAd().get(x));
                }
            }
        }
    }


}
