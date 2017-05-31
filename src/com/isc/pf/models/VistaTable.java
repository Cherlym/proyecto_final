package com.isc.pf.models;

/**
 * Created by alex_ on 31/05/2017.
 */
public class VistaTable {
    private final String nombre;
    private final String horae;
    private final String horas;
    private final String fecha;

    public VistaTable(String nombre, String horae, String horas, String fecha) {
        this.nombre = nombre;
        this.horae = horae;
        this.horas = horas;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getHorae() {
        return horae;
    }

    public String getHoras() {
        return horas;
    }
}
