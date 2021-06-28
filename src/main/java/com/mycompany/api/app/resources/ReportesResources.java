/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api.app.resources;

import com.mycompany.api.app.entitys.Estado;
import com.mycompany.api.app.entitys.Reportes;
import com.mycompany.api.app.repository.ReporteRepository;
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
    public Response agregarReporte(Reportes reporte) {
        try {
            if (reporteRepository.save(reporte, false)) {
                return Response.status(201)
                        .entity("Se creo el Reporte")
                        .build();
            } else {
                return Response.status(400)
                        .entity(reporteRepository.getException().getLocalizedMessage())
                        .build();
            }
        } catch (Exception e) {
            return Response.status(401)
                    .entity(e.getLocalizedMessage()).build();
        }
    }

    //Agregar estados al mismo reporte con el identificador del Reporte
    @PUT
    @Path("/addEstado/{identificador}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response agregarEstadoReporte(@PathParam("identificador") String id, Estado estado) {
        Reportes reporte = new Reportes();
        reporte.setIdentificador(id);

        //busco el reporte para actualizar
        Optional<Reportes> optional = reporteRepository.findById(reporte);

        //agrego los datos de la busqueda al nuevo reporte
        reporte = optional.get();

        //Creo una lista para agregar al nuevo estado con los anteriores
        List<Estado> list = new ArrayList<Estado>();
        list = reporte.getEstados();
        list.add(estado);
        //le adapto el nuevo estado a la lista de estados anteriores
        reporte.setEstados(list);
        try {
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
    public Response actualizarReporte(@PathParam("id") String id,Reportes reporte) {
        Reportes re = new Reportes();
        re.setIdentificador(id);

        //busco el reporte para actualizar
        Optional<Reportes> optional = reporteRepository.findById(re);

        //agrego los datos de la busqueda al nuevo reporte
        re = optional.get();

        //Creo una lista para agregar al nuevo estado con los anteriores
        List<Estado> list = new ArrayList<Estado>();
        list = re.getEstados();
        
        //le adapto el nuevo estado a la lista de estados anteriores
        reporte.setEstados(list);
        try {
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
}
