package com.isc.pf.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by charly on 09/05/2017.
 */
public class Administrador extends Usuario{
    private final StringProperty dpto;

    public Administrador(Integer id, String apPaterno, String apMaterno, String matricula, String nombre, String dpto) {
        super(id, apPaterno, apMaterno, matricula, nombre);
        this.dpto=new SimpleStringProperty(dpto);
    }

    public String getDpto() {
        return dpto.get();
    }

    public StringProperty dptoProperty() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto.set(dpto);
    }
}
