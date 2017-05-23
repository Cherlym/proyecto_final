package com.isc.pf.Views;

import com.isc.pf.models.Administrador;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Created by alex_ on 23/05/2017.
 */
public class RegistroAdminController {
    @FXML
    private TextField matricula;
    @FXML
    private TextField nombre;
    @FXML
    private TextField dpto;

    public void detallesContacto(Administrador a){
        if (a != null) {
            matricula.setText(a.getMatricula());
            nombre.setText(a.getNombre()+" "+a.getApPaterno()+" "+a.getApMaterno());
            dpto.setText(a.getDpto());

        }else{
            matricula.setText("");
            nombre.setText("");
            dpto.setText("");
        }

    }
}
