package com.isc.pf.Views;

import com.isc.pf.Main;
import com.isc.pf.models.VistaTable;
import com.isc.pf.models.ppc;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    private TextField he;
    @FXML
    private TextField hs;
    @FXML
    private TextField txtNombre;
    @FXML
    TextField disp;
    @FXML
    private Label a1;
    @FXML
    private Label a2;
    @FXML
    private TableColumn<ppc,String> nopc=new TableColumn<>("nopc");
    @FXML
    private TableView<ppc> tabla;
    @FXML
    private TableColumn<ppc,String>  disponibilidad=new TableColumn<>("disponibilidad");

    private Stage editDialog;
    private boolean onClic=false;
    private SQLConnection conexion = new SQLConnection();

    @FXML
    public void iniciar(){
        int contactoSelected = tabla.getSelectionModel().getSelectedIndex();
        if (contactoSelected>=0){
            pc.setText(tabla.getItems().get(contactoSelected).getNopc());
        }
        tabla.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> detallesContacto1(newValue));

       /* ppc p= tabla.getSelectionModel().getSelectedItem();
                pc.setText(p.getNopc());
                disp.setText(p.getDisponibilidad());*/
    }
    public void detallesContacto1(ppc c){
        if (c != null) {
            pc.setText(c.getNopc());
            disp.setText(c.getDisponibilidad());
            if (disp.getText().equals("En reparacion")||disp.getText().equals("No Disponible")){
                he.setVisible(false);
                hs.setVisible(false);
                a1.setVisible(false);
                a2.setVisible(false);
                registrar.setVisible(false);

            }else{
                he.setVisible(true);
                hs.setVisible(true);
                a1.setVisible(true);
                a2.setVisible(true);
                registrar.setVisible(true);
            }

        }else{
            pc.setText("");
            disp.setText("");
        }

    }

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
    private void okClic()throws SQLException{
        onClic = true;
        if (onClic) {
            editDialog.hide();
            if(mat.getLength()>=8){
                Main.iniciar();
            }
        }

    }
    private void okClics()throws SQLException{
        onClic = true;
        if (onClic) {
            editDialog.hide();
        }
    }

    @FXML
    private void Registrar() throws SQLException{
        conectar();
        conexion.actualizarRegistro("update pc set disponibilidad='No Disponible' where pc.nopc="+pc.getText()+"");
        conexion.actualizarRegistro("insert into prestamopc values("+pc.getText()+",'"+he.getText()+"','"+hs.getText()+"','"+mat.getText()+"')");
        okClics();
        Main.iniciar();
        alerta(pc.getText(),he.getText(),hs.getText());
    }

    public static void alerta(String ld, String de, String a){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFORMACION");
        alert.setHeaderText("SE HA REGISTRADO SU RESERVACION");
        alert.setContentText("Se ha reservado el equipo No. "+ld+" \nde "+de+" a "+a+".");

        alert.show();
    }
    /*public void campos(){
        int contactoSelected = tabla.getSelectionModel().getSelectedIndex();
        if (contactoSelected>=0){
            pc.setText(tabla.getItems().get(contactoSelected).getNopc());
        }
        }*/

    public void detallesUsuario(ResultSet consulta) throws SQLException{
        if (consulta != null) {
            mat.setText(consulta.getString("matricula"));
            txtNombre.setText(consulta.getString("nombre")+" "+consulta.getString("apellidop")+" "+consulta.getString("apellidom"));

        }else{
            mat.setText("");
        }

    }

}
