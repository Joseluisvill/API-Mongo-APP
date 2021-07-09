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
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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

    public Date fechaActual() throws ParseException {
        try {
            //obtiene fecha instantanea
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String a = now.format(dtf);
            Date fecha = formato.parse(a);
            return fecha;
        } catch (Exception e) {
            System.out.println("fechaReporteEstado() " + e.getLocalizedMessage());
        }
        return null;
    }
}
