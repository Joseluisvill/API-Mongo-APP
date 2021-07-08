/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api.app.entitys;

import com.avbravo.jmoordb.anotations.Ignore;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author villa
 */
public class Estado {

    private String identificador;
    private Date fecha;
    private String comentario;
    private String estado;
    @Ignore
    private String fechaString;

    public Estado() {
    }

    public Estado(String identificador, String fechaString, String comentario, Date fecha, String estado) {
        this.identificador = identificador;
        this.fechaString = fechaString;
        this.fecha = fecha;
        this.comentario = comentario;
        this.estado = estado;
    }

    public String getFechaString() {
        return fechaString;
    }

    public void setFechaString(String fechaString) {
        this.fechaString = fechaString;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setFecha(Date fecha) {
        //System.out.println("set"+fecha);

        this.fecha = fecha;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdentificador() {
        return identificador;
    }

    public Date getFecha() {
        // System.out.println("get"+fecha);
        return fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public String getEstado() {
        return estado;
    }
}
