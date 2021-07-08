/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api.app.entitys;

import com.avbravo.jmoordb.anotations.Id;

/**
 *
 * @author villa
 */
public class RolesAsignados {

    @Id
    private int idRole;
    private boolean activo;

    public RolesAsignados() {
    }

    public RolesAsignados(int idRole, boolean activo) {
        this.idRole = idRole;
        this.activo = activo;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
