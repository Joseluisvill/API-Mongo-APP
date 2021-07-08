/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api.app.entitys;

import com.avbravo.jmoordb.anotations.Embedded;
import com.avbravo.jmoordb.anotations.Id;
import java.util.List;

/**
 *
 * @author villa
 */
public class Usuario {

    @Id
    private String identificador;
    private String nombre;
    private String contrasena;
    private String email;
    private String telefono;
    private boolean activo;
    @Embedded
    private List<RolesAsignados> roles;

    public Usuario() {
    }

    public Usuario(String identificador, String nombre, String contrasena, String email, String telefono, boolean activo, List<RolesAsignados> roles) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.email = email;
        this.telefono = telefono;
        this.activo = activo;
        this.roles = roles;
    }

    public List<RolesAsignados> getRoles() {
        return roles;
    }

    public void setRoles(List<RolesAsignados> roles) {
        this.roles = roles;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
