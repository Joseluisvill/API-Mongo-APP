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
public class Roles {
    @Id
    private int idRole;
    private String nombre;

    public Roles() {
    }

    public Roles(int idRole, String nombre) {
        this.idRole = idRole;
        this.nombre = nombre;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
