package com.grupo4.mbintegrador.model;

public class PerfilPermiso {
    private int ipermId;
    private MenuWeb menuWeb;
    private PerfilUsuario perfilUsuario;

    // Getters y Setters
    public int getIpermId() {
        return ipermId;
    }

    public void setIpermId(int ipermId) {
        this.ipermId = ipermId;
    }

    public MenuWeb getMenuWeb() {
        return menuWeb;
    }

    public void setMenuWeb(MenuWeb menuWeb) {
        this.menuWeb = menuWeb;
    }

    public PerfilUsuario getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }
}
