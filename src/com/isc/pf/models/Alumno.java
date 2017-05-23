package com.isc.pf.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by charly on 09/05/2017.
 */
/*EJEMPLO DE CAMBIO SIN ACTUALIZAR*/
//hola soy cheno
    //Ya llegue... ManuPM

public class Alumno extends Usuario{
    private final String programaEducativo;
    private final int semestre; // La propiedad se cambio de byte a integer para poder utilizar el frame

    public Alumno(String id, String nombre, String apellidoPaterno, String apellidoMaterno, String programaEducativo, int semestre) {
        super(id, nombre, apellidoPaterno, apellidoMaterno);
        this.programaEducativo = programaEducativo;
        this.semestre = semestre;
    }

    public Alumno(Integer id, String apPaterno, String apMaterno, String matricula, String nombre, String programaEducativo, int semestre) {
        super(id, apPaterno, apMaterno, matricula, nombre);
        this.programaEducativo = programaEducativo;
        this.semestre = semestre;
    }


    public String getProgramaEducativo() {
        return programaEducativo;
    }

    public int getSemestre() {
        return semestre;
    }
}