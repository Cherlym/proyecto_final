package com.isc.pf.Views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by School on 29/05/2017.
 */
public class VistaPrestamoPCController {
    @FXML
    private Button registrar;
    @FXML
    private Button cancelar;
    @FXML
    private TextField pc;
    @FXML
    TextField disponibilidad;
    @FXML
    TextField horario;

    public void detallesContacto(ResultSet consulta)throws SQLException{
    pc.setText(consulta.getString("pc"));
    disponibilidad.setText(consulta.getString("Disponibilidad"));
    horario.setText(consulta.getString("horario"));
    }

}
