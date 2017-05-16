package com.cahd.bitacora.models.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by alex_ on 31/01/2017.
 */
public class Maestro extends Usuario {
    private final StringProperty division;

    public Maestro(String id, String nombre, String apellidoPaterno, String apellidoMaterno, String division) {
        super(id, nombre, apellidoPaterno, apellidoMaterno);
        this.division=new SimpleStringProperty(division);
    }
}
