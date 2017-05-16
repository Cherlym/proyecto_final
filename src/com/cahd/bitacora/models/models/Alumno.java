package com.cahd.bitacora.models.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by charly on 09/05/2017.
 */

public class Alumno {
    private final StringProperty programaEducativo;
    private final IntegerProperty semestre; // La propiedad se cambio de byte a integer para poder utilizar el frame

    public Alumno(){
        this(null, Integer.parseInt(null));
    }
    public Alumno(String programaEducativo,int semestre){
        this.programaEducativo= new SimpleStringProperty(programaEducativo);
        this.semestre = new SimpleIntegerProperty(semestre);
    }

    public String getProgramaEducativo() {
        return programaEducativo.get();
    }

    public StringProperty programaEducativoProperty() {
        return programaEducativo;
    }

    public void setProgramaEducativo(String programaEducativo) {
        this.programaEducativo.set(programaEducativo);
    }

    public int getSemestre() {
        return semestre.get();
    }

    public IntegerProperty semestreProperty() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre.set(semestre);
    }
}