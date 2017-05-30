package com.isc.pf.Views;

import com.isc.pf.Main;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by alex_ on 30/05/2017.
 */
public class prestamoSalaController {
    @FXML
    private RadioButton s1;
    @FXML
    private RadioButton s2;
    @FXML
    private TableView tabla;

    @FXML
    private TableColumn campoNombre;

    @FXML
    TableColumn horaS;

    @FXML
    TableColumn horaE;

    final ToggleGroup group = new ToggleGroup();


    // Objeto clase conexionMySQL e instanciar clase
    private SQLConnection conexion = new SQLConnection();

    // Crear un modelo del JTable
    private DefaultTableModel modelo;

    /**
     * Creates new form milancorp
     */
    public void Main() throws SQLException{
       // modelo = (javax.swing.table.DefaultTableModel) tabla.getModel();
        //conectar();

        // Llenar los datos de la tabla
        llenarTabla("SELECT * FROM prestamoSala ORDER BY disponibilidad");

        // Cerrar conexion
        conexion.cerrarConexion();
    }

    public void conectar(){
        conexion.crearConexion("jdbc:postgresql://localhost/proyectoFInal","postgres","a123",false);
    }
    public void llenarTabla(String SQL) throws SQLException {
        conectar();
        // Iniciar registros de la tabla
        ResultSet consulta = conexion.ejecutarConsulta(SQL);
        try{
            while (consulta.next()) {
                consulta.getString("ns");
                consulta.getString("horas");

                String[] registros = {
                        consulta.getString("ns"),
                        consulta.getString("horas"),

                };

                modelo.addRow(registros);

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
    }
    @FXML
    public void selected1(){
        s2.setSelected(true);
        s2.setToggleGroup(group);
        s1.setToggleGroup(group);
    }
}
