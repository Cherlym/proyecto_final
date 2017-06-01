package com.isc.pf.models;

/**
 * Created by alex_ on 31/05/2017.
 */
public class ppc {
    private String nopc;
    private String disponibilidad;

    public ppc(String nopc, String disponibilidad) {
        this.nopc = nopc;
        this.disponibilidad = disponibilidad;
    }

    public String getNopc() {
        return nopc;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }
}
