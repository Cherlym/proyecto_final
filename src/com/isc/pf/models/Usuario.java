package com.isc.pf.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Usuario {
    private final StringProperty matricula;
    private final StringProperty nombre;
    private final IntegerProperty id;
    private final StringProperty apPaterno;
    private final StringProperty apMaterno;

    public Usuario(String id, String nombre, String apellidoPaterno, String apellidoMaterno){
        this(null,null,null,null,null);
    }

    public Usuario(Integer id,String apPaterno,String apMaterno,String matricula,String nombre) {
        //DATOS DE PRUEVA
        this.id=new SimpleIntegerProperty(id);
        this.matricula=new SimpleStringProperty(matricula);
        this.nombre= new SimpleStringProperty(nombre);
        this.apPaterno= new SimpleStringProperty(apPaterno);
        this.apMaterno=new SimpleStringProperty(apMaterno);
    }

    public String getMatricula() {return matricula.get();}

    public StringProperty matriculaProperty() {return matricula;}

    public void setMatricula(String matricula) {this.matricula.set(matricula);}

    public String getNombre() {return nombre.get();}

    public StringProperty nombreProperty() {return nombre;}

    public void setNombre(String nombre) {this.nombre.set(nombre);}

    public int getId() {return id.get();}

    public IntegerProperty idProperty() {return id;}

    public void setId(int id) {this.id.set(id);}

    public String getApPaterno() {return apPaterno.get();}

    public StringProperty apPaternoProperty() {return apPaterno;}

    public void setApPaterno(String apPaterno) {this.apPaterno.set(apPaterno);}

    public String getApMaterno() {return apMaterno.get();}

    public StringProperty apMaternoProperty() {return apMaterno;}

    public void setApMaterno(String apMaterno) {this.apMaterno.set(apMaterno);}
}