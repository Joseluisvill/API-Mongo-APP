/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api.app.entitys;

import com.avbravo.jmoordb.anotations.Ignore;
import com.mycompany.api.services.FechaServices;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Inject;

/**
 *
 * @author villa
 */
public class Estado {

    private int id;
    private String identificador;
    private Date fecha;
    private String comentario;
    private String estado;
    @Ignore
    private String fechaString;

    public Estado() {
    }

    public Estado(String identificador, String fechaString, String comentario, Date fecha, String estado, int id) {
        this.identificador = identificador;
        this.fechaString = fechaString;
        this.fecha = fecha;
        this.comentario = comentario;
        this.estado = estado;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
        if (fecha != null) {
            String a = dateFormatter.format(fecha);
            setFechaString(a);
        }
        return fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public String getEstado() {
        return estado;
    }
}
