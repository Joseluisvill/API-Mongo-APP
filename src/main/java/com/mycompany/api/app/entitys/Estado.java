/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api.app.entitys;

import com.avbravo.jmoordb.anotations.DatePattern;
import java.util.Date;


/**
 *
 * @author villa
 */
public class Estado {
    private String identificador;
    @DatePattern
    private Date fecha;
    private String comentario;
    private String estado;
    
    public Estado(){
    }
    
    public Estado(String identificador, Date fecha, String comentario, String estado) {
        this.identificador = identificador;
        this.fecha = fecha;
        this.comentario = comentario;
        this.estado = estado;
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
        return fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public String getEstado() {
        return estado;
    }
}
