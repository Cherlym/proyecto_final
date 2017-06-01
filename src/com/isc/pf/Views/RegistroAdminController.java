package com.isc.pf.Views;

import com.isc.pf.Main;
import com.isc.pf.models.Administrador;
import com.sun.org.apache.bcel.internal.generic.PUSH;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

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
    @FXML
    private RadioButton sala;
    @FXML
    private RadioButton pc;

    final ToggleGroup group = new ToggleGroup();


    private Stage editDialog;
    private boolean onClic=false;

    public void setStageDialog (Stage stageDialogo){
        editDialog=stageDialogo;
    }

    @FXML
    public void selected() throws SQLException{
        sala.setSelected(true);
        sala.setToggleGroup(group);
        pc.setToggleGroup(group);
        Main.iniciaPrestamoSala(matricula.getText());
    }


    public boolean clicOk(){
        return onClic;
    }

    @FXML
    private void okClic(){
        onClic = true;
        if (onClic) {
            editDialog.hide();
        }

    }
    @FXML
    public void selected1()throws SQLException{
        pc.setSelected(true);
        sala.setToggleGroup(group);
        pc.setToggleGroup(group);
        Main.iniciaPrestamoPc(matricula.getText());
    }

    public void detallesContacto(ResultSet consulta) throws SQLException{
        matricula.setText(consulta.getString("matricula"));
        nombre.setText(consulta.getString("nombre")+" "+consulta.getString("apellidop")+" "+consulta.getString("apellidom"));
        dpto.setText(consulta.getString("departamento"));

    }
}
