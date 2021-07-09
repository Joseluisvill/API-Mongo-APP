/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api.app.resources;

import com.mycompany.api.app.entitys.Estado;
import com.mycompany.api.app.entitys.Reportes;
import com.mycompany.api.app.repository.ReporteRepository;
import com.mycompany.api.services.ReporteServices;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author villa
 */
@RolesAllowed("admin")
@Path("/reportes")
public class ReportesResources {

    @Inject
    ReporteRepository reporteRepository;

    @Inject
    ReporteServices reporteServices;

    //Mostrar todos
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reportes> todos() {
        return reporteRepository.findAll();
    }

    //Crear reporte
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Reportes agregarReporte(Reportes reporte) {
        try {
            reporte = reporteServices.add(reporte);
            if (reporteRepository.save(reporte, false)) {
                return reporte;
            }
        } catch (Exception e) {
            System.out.println("agregarReporte() " + e.getLocalizedMessage());
        }
        return reporte;
    }

    //Agregar estados al mismo reporte con el identificador del Reporte
    @PUT
    @Path("/addEstado/{identificador}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response agregarEstadoReporte(@PathParam("identificador") String id, Estado estado) throws ParseException {

        try {
            Reportes reporte = reporteServices.addEstado(estado, id);

            if (reporteRepository.update(reporte)) {
                return Response.status(201).entity("Update Ok").build();
            } else {
                return Response.status(400)
                        .entity(reporteRepository.getException().getLocalizedMessage()).build();
            }
        } catch (Exception e) {
            return Response.status(401).entity(e.getLocalizedMessage()).build();
        }
    }

    //Actualizar reporte dependiendo del identificador, pero se seguiran manteniendo los estados anteriores
    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarReporte(@PathParam("id") String id, Reportes reporte) {

        try {
            reporte = reporteServices.actualizar(id, reporte);
            if (reporteRepository.update(reporte)) {
                return Response.status(201).entity("Update Ok").build();
            } else {
                return Response.status(400)
                        .entity(reporteRepository.getException().getLocalizedMessage()).build();
            }
        } catch (Exception e) {
            return Response.status(401).entity(e.getLocalizedMessage()).build();
        }
    }

    //Buscar un reporte en especifico por el identificador
    @GET
    @Path("/search/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Reportes buscarIdReporte(@PathParam("id") String id) {
        Reportes reporte = new Reportes();
        try {
            reporte.setIdentificador(id);
            Optional<Reportes> optional = reporteRepository.findById(reporte);
            if (optional.isPresent()) {
                reporte = optional.get();
                //parseo fecha
                SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
                reporte.setFechaString(dateFormatter.format(reporte.getFecha()));
                return reporte;
            }
        } catch (Exception e) {
            System.out.print("error" + e.getLocalizedMessage());
        }
        return reporte;
    }
}
