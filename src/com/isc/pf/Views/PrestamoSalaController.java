package com.isc.pf.Views;

import com.isc.pf.Main;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by School on 23/05/2017.
 */
public class PrestamoSalaController {
    private Stage editDialog;
    private boolean onClic=false;

    @FXML
    private RadioButton sala1;
    @FXML
    private RadioButton sala2;
    @FXML
    private TextField horario;

    final ToggleGroup group = new ToggleGroup();

    public void setStageDialog (Stage stageDialogo){
        editDialog=stageDialogo;
    }
    @FXML
    public void seleccion(){
        sala1.setSelected(true);
        sala1.setToggleGroup(group);
        sala2.setToggleGroup(group);
        Main.iniciaPrestamoSala();
    }
    public void detallesContacto(ResultSet consulta) throws SQLException {
        horario.setText(consulta.getString("Horario"));
    }

}
