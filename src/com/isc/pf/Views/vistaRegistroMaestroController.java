package com.isc.pf.Views;

import com.isc.pf.Main;
import com.isc.pf.models.Maestro;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by alex_ on 18/05/2017.
 */
public class vistaRegistroMaestroController  {
    private Stage editDialog;
    private boolean onClic=false;

    @FXML
    private RadioButton sala;
    @FXML
    private RadioButton pc;
    @FXML
    private TextField id;
    @FXML
    private TextField nombre;
    @FXML
    private TextField division;

    final ToggleGroup group = new ToggleGroup();


    public void setStageDialog (Stage stageDialogo){
        editDialog=stageDialogo;
    }

    @FXML
    public void selected() throws SQLException{
        sala.setSelected(true);
        sala.setToggleGroup(group);
        pc.setToggleGroup(group);
        Main.iniciaPrestamoSala(id.getText());
    }

    @FXML
    private void okClic(){
        onClic = true;
        if (onClic) {
            editDialog.hide();
        }

    }

    public void detallesContacto(ResultSet consulta) throws SQLException{
        if (consulta != null) {
            id.setText(consulta.getString("matricula"));
            nombre.setText(consulta.getString("nombre")+" "+consulta.getString("apellidop")+" "+consulta.getString("apellidom"));
            division.setText(consulta.getString("division"));

        }else{
            id.setText("");
        }

    }

    @FXML
    public void selected1(){
        pc.setSelected(true);
        sala.setToggleGroup(group);
        pc.setToggleGroup(group);
        Main.iniciaPrestamoPc();
    }



}
