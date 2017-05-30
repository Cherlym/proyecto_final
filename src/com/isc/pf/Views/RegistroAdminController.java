package com.isc.pf.Views;

import com.isc.pf.Main;
import com.isc.pf.models.Administrador;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by alex_ on 23/05/2017.
 */
public class RegistroAdminController {
    @FXML
    private RadioButton pc;
    @FXML
    private RadioButton sala;
    @FXML
    private TextField matricula;
    @FXML
    private TextField nombre;
    @FXML
    private TextField dpto;
    final ToggleGroup group = new ToggleGroup();

    public void detallesContacto(ResultSet consulta) throws SQLException{
        matricula.setText(consulta.getString("matricula"));
        nombre.setText(consulta.getString("nombre")+" "+consulta.getString("apellidop")+" "+consulta.getString("apellidom"));
        dpto.setText(consulta.getString("departamento"));

    }

    public void select(){
        pc.setSelected(true);
        pc.setToggleGroup(group);
        sala.setToggleGroup(group);
        Main.iniciaPrestamoPc();
    }
    public void select1(){
        sala.setSelected(true);
        sala.setToggleGroup(group);
        pc.setToggleGroup(group);
        Main.iniciaPrestamoSala();
    }
}
