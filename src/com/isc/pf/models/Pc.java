package com.isc.pf.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pc {
    private final StringProperty idPc;
    private final StringProperty disponibilidad;

    public Pc(){
        this(null,null);
    }
    public Pc(String idPc, String disponibilidad) {
        this.idPc = new SimpleStringProperty(idPc);
        this.disponibilidad=new SimpleStringProperty(disponibilidad);

    }

    public String getIdPc() {
        return idPc.get();
    }

    public StringProperty idPcProperty() {
        return idPc;
    }

    public void setIdPc(String idPc) {
        this.idPc.set(idPc);
    }

    public String getDisponibilidad() {
        return disponibilidad.get();
    }

    public StringProperty disponibilidadProperty() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad.set(disponibilidad);
    }
}
