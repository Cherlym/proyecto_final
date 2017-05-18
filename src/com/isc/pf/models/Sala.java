package com.isc.pf.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sala {
    private final StringProperty edificio;
    private final IntegerProperty noSala;
    private final StringProperty nombreSala;

    public Sala(){
        this(null,null,null);
    }
    public Sala(String edificio, Integer noSala, String nombreSala) {
        this.edificio = new SimpleStringProperty(edificio);
        this.noSala = new SimpleIntegerProperty(noSala);
        this.nombreSala = new SimpleStringProperty(nombreSala);
    }

    public String getEdificio() {
        return edificio.get();
    }

    public StringProperty edificioProperty() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio.set(edificio);
    }

    public int getNoSala() {
        return noSala.get();
    }

    public IntegerProperty noSalaProperty() {
        return noSala;
    }

    public void setNoSala(int noSala) {
        this.noSala.set(noSala);
    }

    public String getNombreSala() {
        return nombreSala.get();
    }

    public StringProperty nombreSalaProperty() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala.set(nombreSala);
    }
}
