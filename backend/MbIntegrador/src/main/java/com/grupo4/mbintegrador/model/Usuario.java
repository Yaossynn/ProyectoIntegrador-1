package com.grupo4.mbintegrador.model;

import java.util.Date;

public class Usuario {
    private int iusuId;
    private String vusuNomb;
    private String vusuApel;
    private String vusuCorr;
    private String vusuClav;
    private int iusuTipo;
    private int iusuEsta;
    private Date dusuFecc;
    private Date dusuFecm;
    private String vusuUsuc;
    private String vusuUsum;
    private PerfilUsuario perfilUsuario;  // Relación con la tabla PerfilUsuario

    // Getters y Setters
    public int getIusuId() {
        return iusuId;
    }

    public void setIusuId(int iusuId) {
        this.iusuId = iusuId;
    }

    public String getVusuNomb() {
        return vusuNomb;
    }

    public void setVusuNomb(String vusuNomb) {
        this.vusuNomb = vusuNomb;
    }

    public String getVusuApel() {
        return vusuApel;
    }

    public void setVusuApel(String vusuApel) {
        this.vusuApel = vusuApel;
    }

    public String getVusuCorr() {
        return vusuCorr;
    }

    public void setVusuCorr(String vusuCorr) {
        this.vusuCorr = vusuCorr;
    }

    public String getVusuClav() {
        return vusuClav;
    }

    public void setVusuClav(String vusuClav) {
        this.vusuClav = vusuClav;
    }

    public int getIusuTipo() {
        return iusuTipo;
    }

    public void setIusuTipo(int iusuTipo) {
        this.iusuTipo = iusuTipo;
    }

    public int getIusuEsta() {
        return iusuEsta;
    }

    public void setIusuEsta(int iusuEsta) {
        this.iusuEsta = iusuEsta;
    }

    public Date getDusuFecc() {
        return dusuFecc;
    }

    public void setDusuFecc(Date dusuFecc) {
        this.dusuFecc = dusuFecc;
    }

    public Date getDusuFecm() {
        return dusuFecm;
    }

    public void setDusuFecm(Date dusuFecm) {
        this.dusuFecm = dusuFecm;
    }

    public String getVusuUsuc() {
        return vusuUsuc;
    }

    public void setVusuUsuc(String vusuUsuc) {
        this.vusuUsuc = vusuUsuc;
    }

    public String getVusuUsum() {
        return vusuUsum;
    }

    public void setVusuUsum(String vusuUsum) {
        this.vusuUsum = vusuUsum;
    }

    public PerfilUsuario getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }
}
