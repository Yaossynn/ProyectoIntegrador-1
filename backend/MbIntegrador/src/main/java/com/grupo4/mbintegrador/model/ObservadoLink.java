package com.grupo4.mbintegrador.model;

import java.util.Date;

public class ObservadoLink {
    private int iolinId;
    private Observado observado;  // Relación con la tabla Observado
    private String voliRuta;
    private int ioliEsta;
    private String voliUsuc;
    private String voliUsum;
    private Date doiliFecc;
    private Date doiliFecm;

    // Getters y Setters
    public int getIolinId() {
        return iolinId;
    }

    public void setIolinId(int iolinId) {
        this.iolinId = iolinId;
    }

    public Observado getObservado() {
        return observado;
    }

    public void setObservado(Observado observado) {
        this.observado = observado;
    }

    public String getVoliRuta() {
        return voliRuta;
    }

    public void setVoliRuta(String voliRuta) {
        this.voliRuta = voliRuta;
    }

    public int getIoliEsta() {
        return ioliEsta;
    }

    public void setIoliEsta(int ioliEsta) {
        this.ioliEsta = ioliEsta;
    }

    public String getVoliUsuc() {
        return voliUsuc;
    }

    public void setVoliUsuc(String voliUsuc) {
        this.voliUsuc = voliUsuc;
    }

    public String getVoliUsum() {
        return voliUsum;
    }

    public void setVoliUsum(String voliUsum) {
        this.voliUsum = voliUsum;
    }

    public Date getDoiliFecc() {
        return doiliFecc;
    }

    public void setDoiliFecc(Date doiliFecc) {
        this.doiliFecc = doiliFecc;
    }

    public Date getDoiliFecm() {
        return doiliFecm;
    }

    public void setDoiliFecm(Date doiliFecm) {
        this.doiliFecm = doiliFecm;
    }
}
