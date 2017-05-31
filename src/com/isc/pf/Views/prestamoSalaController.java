package com.isc.pf.Views;

import com.isc.pf.models.VistaTable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by alex_ on 30/05/2017.
 */
public class prestamoSalaController {
    @FXML
    private RadioButton s1;
    @FXML
    private RadioButton s2;
    @FXML
    private TableView<VistaTable> tabla;

    @FXML
    private TableColumn<VistaTable,String> campoNombre=new TableColumn<>("Nombre");

    @FXML
    private TableColumn<VistaTable,String>  horaS=new TableColumn<>("Hora Entrada");

    @FXML
    private TableColumn<VistaTable,String>  horaE=new TableColumn<>("Hora Salida");

    @FXML
    private TableColumn<VistaTable,String>  fecha=new TableColumn<>("Fecha");

    @FXML
    private DatePicker dp;

    @FXML
    private TextField de;

    @FXML
    private TextField a;



    private int valor=0;
    private String matr="";
    private Stage editDialog;
    private boolean onClic=false;


    final ToggleGroup group = new ToggleGroup();
    private SQLConnection conexion = new SQLConnection();

    public void setStageDialogo2 (Stage stageDialogo){
        editDialog=stageDialogo;
    }


    public void conectar(){
        conexion.crearConexion("jdbc:postgresql://localhost/proyectoFInal","postgres","a123",false);
    }
    public void llenarTabla(String SQL) throws SQLException {
        conectar();
        ResultSet consulta = conexion.ejecutarConsulta(SQL);

        campoNombre.setCellValueFactory(new PropertyValueFactory<VistaTable,String>("nombre"));
        horaE.setCellValueFactory(new PropertyValueFactory<VistaTable,String>("horae"));
        horaS.setCellValueFactory(new PropertyValueFactory<VistaTable,String>("horas"));
        fecha.setCellValueFactory(new PropertyValueFactory<VistaTable,String>("fecha"));

        try{
            while (consulta.next()) {
                String nf=consulta.getString("descripcion");
                String he=consulta.getString("horae");
                String hs=consulta.getString("horas");
                String fecha=consulta.getString("fecha");

                VistaTable vt=new VistaTable(nf,he,hs,fecha);

                tabla.getItems().addAll(vt);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de SQL: " + e.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        }
        //conexion.cerrarConexion();
    }
    @FXML
    public void selected(){
        s1.setSelected(true);
        s1.setToggleGroup(group);
        s2.setToggleGroup(group);
        valor=1;
    }
    @FXML
    public void selected1(){
        s2.setSelected(true);
        s2.setToggleGroup(group);
        s1.setToggleGroup(group);
        valor=2;
    }

    @FXML
    public void registrar(){
        conectar();
        String ld=dp.getValue().toString();
       conexion.actualizarRegistro("insert into prestamoSala values("+valor+",'"+de.getText()+"','"+a.getText()+"','"+ld+"','"+matr+"')");
        alerta(dp.getValue(),de.getText(),a.getText());
        okClics();
    }

    public void obtenerId(String id){
        matr=id;
    }

    private void okClics(){
        onClic = true;
        if (onClic) {
            editDialog.close();
        }

    }
    public static void alerta(LocalDate ld, String de, String a){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("IMFORMACION");
        alert.setHeaderText("SE HA REGISTRADO SU RESERVACION");
        alert.setContentText("Se ha reservado la sala el dia "+ld+" \nde "+de+" a "+a+".");

        alert.show();
    }
    @FXML
    public void cancelarr(){
        okClics();
    }

}
