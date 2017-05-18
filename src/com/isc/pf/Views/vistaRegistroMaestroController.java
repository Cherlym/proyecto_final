package com.isc.pf.Views;

import com.isc.pf.Main;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * Created by alex_ on 18/05/2017.
 */
public class vistaRegistroMaestroController {
    private Stage editDialog;
    private boolean onClic=false;

    @FXML
    private RadioButton sala;
    @FXML
    private RadioButton pc;

    final ToggleGroup group = new ToggleGroup();


    public void setStageDialog (Stage stageDialogo){
        editDialog=stageDialogo;
    }

    @FXML
    public void selected(){
        sala.setSelected(true);
        sala.setToggleGroup(group);
        pc.setToggleGroup(group);
        Main.iniciaPrestamoSala();
    }

    @FXML
    public void selected1(){
        pc.setSelected(true);
        sala.setToggleGroup(group);
        pc.setToggleGroup(group);
        Main.iniciaPrestamoPc();
    }



}
