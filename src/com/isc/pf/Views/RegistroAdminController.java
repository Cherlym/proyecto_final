package com.isc.pf.Views;

import com.isc.pf.models.Administrador;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

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

    public void detallesContacto(ResultSet consulta) throws SQLException{
        matricula.setText(consulta.getString("matricula"));
        nombre.setText(consulta.getString("nombre")+" "+consulta.getString("apellidop")+" "+consulta.getString("apellidom"));
        dpto.setText(consulta.getString("departamento"));

    }
}
