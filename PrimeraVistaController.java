package com.ISC.views;

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
}
