package com.grupo4.mbintegrador.model;

import java.util.Date;

public class TarifaMovil {
    private int itarId;
    private Date dtarFecc;
    private double ntarTarif;
    private double ntarProm;
    private String ttarHsal;
    private String vtarCate;
    private Ciudad ciudadOrigen;
    private Ciudad ciudadDestino;

    // Getters y Setters
    public int getItarId() {
        return itarId;
    }

    public void setItarId(int itarId) {
        this.itarId = itarId;
    }

    public Date getDtarFecc() {
        return dtarFecc;
    }

    public void setDtarFecc(Date dtarFecc) {
        this.dtarFecc = dtarFecc;
    }

    public double getNtarTarif() {
        return ntarTarif;
    }

    public void setNtarTarif(double ntarTarif) {
        this.ntarTarif = ntarTarif;
    }

    public double getNtarProm() {
        return ntarProm;
    }

    public void setNtarProm(double ntarProm) {
        this.ntarProm = ntarProm;
    }

    public String getTtarHsal() {
        return ttarHsal;
    }

    public void setTtarHsal(String ttarHsal) {
        this.ttarHsal = ttarHsal;
    }

    public String getVtarCate() {
        return vtarCate;
    }

    public void setVtarCate(String vtarCate) {
        this.vtarCate = vtarCate;
    }

    public Ciudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(Ciudad ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(Ciudad ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }
}
