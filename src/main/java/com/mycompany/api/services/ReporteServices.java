/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api.services;

import com.mycompany.api.app.entitys.Estado;
import com.mycompany.api.app.entitys.Reportes;
import com.mycompany.api.app.repository.ReporteRepository;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author villa
 */
@Stateless
public class ReporteServices {

    @Inject
    ReporteRepository reporteRepository;

    @Inject
    FechaServices fechaservices;

    public ReporteServices() {
    }

    public Reportes addEstado(Estado estado, String id) throws ParseException {
        Reportes reporte = new Reportes();
        reporte.setIdentificador(id);

        //busco el reporte para actualizar
        Optional<Reportes> optional = reporteRepository.findById(reporte);
        try {
            //agrego los datos de la busqueda al nuevo reporte
            reporte = optional.get();

            estado.setFecha(fechaservices.fechaReporteEstado(estado));
            //Creo una lista para agregar al nuevo estado con los anteriores
            List<Estado> list = new ArrayList<Estado>();
            list = reporte.getEstados();
            list.add(estado);
            //le adapto el nuevo estado a la lista de estados anteriores
            reporte.setEstados(list);
            reporte.setEstado(estado.getEstado());

            return reporte;
        } catch (Exception e) {
            System.out.println("addEstado() " + e.getLocalizedMessage());
        }
        return reporte;
    }

    public Reportes actualizar(String id, Reportes reporte) {
        Reportes re = new Reportes();
        //re.setIdentificador(id);
        reporte.setIdentificador(id);
        //busco el reporte para actualizar
        Optional<Reportes> optional = reporteRepository.findById(reporte);
        try {
            if (optional.isPresent()) {
                //agrego los datos de la busqueda al nuevo reporte
                re = optional.get();

                //Creo una lista para agregar al nuevo estado con los anteriores
                List<Estado> list = new ArrayList<Estado>();
                list = re.getEstados();

                //le adapto el nuevo estado a la lista de estados anteriores
                reporte.setEstados(list);
                //mantengo el estado anterior tambien
                reporte.setEstado(re.getEstado());

                reporte.setFecha(fechaservices.fechaReporte(reporte));
                return reporte;
            } else {
                System.out.println("No esta presente");
            }

        } catch (Exception e) {
            System.out.println("actualizar() " + e.getLocalizedMessage());
        }
        return reporte;
    }

    public Reportes add(Reportes reporte) throws ParseException {
        reporte.setFecha(fechaservices.fechaReporte(reporte));
        return reporte;
    }

}
