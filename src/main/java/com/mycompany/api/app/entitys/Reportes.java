/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api.app.entitys;

import com.avbravo.jmoordb.anotations.Embedded;
import com.avbravo.jmoordb.anotations.Id;
import com.avbravo.jmoordb.anotations.Ignore;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author villa
 */
public class Reportes {

    @Id
    private String identificador;
    private String descripcion;
    private Date fecha;
    @Embedded
    private List<Coordenadas> ubicacion;
    private String imagen;
    private String estado;
    private String identificadorUsuario;
    @Embedded
    private List<Estado> estados;
    @Ignore
    private String fechaString;

    public Reportes() {
    }

    public Reportes(String descripcion, List<Coordenadas> ubicacion, String imagen, List<Estado> estados, String identificador, String estado, String identificadorUsuario, Date fecha, String fechaString) {
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.imagen = imagen;
        this.estados = estados;
        this.identificador = identificador;
        this.estado = estado;
        this.identificadorUsuario = identificadorUsuario;
        this.fecha = fecha;
        this.fechaString = fechaString;
    }

    public String getFechaString() {
        return fechaString;
    }

    public void setFechaString(String fechaString) {
        this.fechaString = fechaString;
    }


    public Date getFecha() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
        if (fecha != null) {
            String a = dateFormatter.format(fecha);
            setFechaString(a);
        }
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdentificadorUsuario() {
        return identificadorUsuario;
    }

    public void setIdentificadorUsuario(String identificadorUsuario) {
        this.identificadorUsuario = identificadorUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUbicacion(List<Coordenadas> ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<Coordenadas> getUbicacion() {
        return ubicacion;
    }

    public String getImagen() {
        return imagen;
    }

    public List<Estado> getEstados() {
        return estados;
    }

}
