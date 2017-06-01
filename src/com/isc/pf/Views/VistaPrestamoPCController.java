package com.isc.pf.Views;

import com.isc.pf.Main;
import com.isc.pf.models.VistaTable;
import com.isc.pf.models.ppc;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
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
    private TextField mat;

    @FXML
    TextField horario;
    @FXML
    private TableColumn<ppc,String> nopc=new TableColumn<>("nopc");
    @FXML
    private TableView<ppc> tabla;
    @FXML
    private TableColumn<ppc,String>  disponibilidad=new TableColumn<>("disponibilidad");

    private Stage editDialog;
    private boolean onClic=false;
    private SQLConnection conexion = new SQLConnection();
    public void setStageDialog (Stage stageDialogo){
        editDialog=stageDialogo;
    }
    public void conectar(){
        conexion.crearConexion("jdbc:postgresql://localhost/proyectoFInal","postgres","a123",false);
    }
    public void detallesContacto(String SQL)throws SQLException{
        conectar();
        ResultSet consultas = conexion.ejecutarConsulta(SQL);

        nopc.setCellValueFactory(new PropertyValueFactory<ppc,String>("nopc"));
        disponibilidad.setCellValueFactory(new PropertyValueFactory<ppc,String>("disponibilidad"));
        /*
    pc.setText(consulta.getString("pc"));
    disponibilidad.setText(consulta.getString("Disponibilidad"));
    horario.setText(consulta.getString("horario"));*/
        ppc ss;
        try{
            while (consultas.next()) {
                String nf=consultas.getString("nopc");
                String he=consultas.getString("disponibilidad");

                ss=new ppc(nf,he);

                tabla.getItems().addAll(ss);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de SQL: " + e.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void setTitulo(String mats){
        mat.setText(mats);
    }

    @FXML
    private void okClic(){
        onClic = true;
        if (onClic) {
            editDialog.hide();
            Main.iniciar();
        }

    }

}
