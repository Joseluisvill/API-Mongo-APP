/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api.services;

import com.mycompany.api.app.entitys.Estado;
import com.mycompany.api.app.entitys.Reportes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author villa
 */
@Stateless
public class FechaServices {

    public FechaServices() {
    }

    public Date fechaReporteEstado(Estado estado) throws ParseException {
        try {
            //Para convertir la fechas 
            SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
            Date fechaa = formato.parse(estado.getFechaString());
            return fechaa;
        } catch (Exception e) {
            System.out.println("fechaReporteEstado() " + e.getLocalizedMessage());
        }
        return null;
    }

    public Date fechaReporte(Reportes reporte) throws ParseException {
        try {
            //Para convertir la fechas 
            SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
            Date fechaa = formato.parse(reporte.getFechaString());
            return fechaa;
        } catch (Exception e) {
            System.out.println("fechaReporte() " + e.getLocalizedMessage());
        }
        return null;
    }
}
