package com.isc.pf.models;

/**
 * Created by charly on 09/05/2017.
 */
public class Administrador extends Usuario {


    public Administrador(String id, String nombre, String apellidoPaterno, String apellidoMaterno) {
        super(id, nombre, apellidoPaterno, apellidoMaterno);
    }

    public Administrador(Integer id, String apPaterno, String apMaterno, Integer matricula, String nombre) {
        super(id, apPaterno, apMaterno, matricula, nombre);
    }



}
