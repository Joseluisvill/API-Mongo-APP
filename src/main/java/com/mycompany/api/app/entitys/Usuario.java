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
public class Usuario {
    @Id
    private String identificador;
    private String nombre;
    private String contrasena;
    private String email;
    private String tel;
    private String rol;
    
    public Usuario(){
}
    public Usuario(String identificador, String nombre, String contrasena, String email, String tel, String rol) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.email = email;
        this.tel = tel;
        this.rol = rol;
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

    public String getTel() {
        return tel;
    }

    public String getRol() {
        return rol;
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

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
