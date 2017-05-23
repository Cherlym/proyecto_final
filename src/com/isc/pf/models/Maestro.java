package com.isc.pf.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by alex_ on 31/01/2017.
 */
public class Maestro extends Usuario {
    private final StringProperty division;

    public Maestro(int id, String nombre, String apellidoPaterno,String matricula, String apellidoMaterno, String division) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, matricula);
        this.division=new SimpleStringProperty(division);
    }

    public String getDivision() {
        return division.get();
    }

    public StringProperty divisionProperty() {
        return division;
    }
}
