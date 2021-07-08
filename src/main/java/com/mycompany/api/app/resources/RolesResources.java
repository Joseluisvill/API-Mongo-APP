/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api.app.resources;

import com.avbravo.jmoordb.mongodb.history.services.AutoincrementableServices;
import com.mycompany.api.app.entitys.Roles;
import com.mycompany.api.app.repository.RolesRepository;
import com.mycompany.api.services.CollectionincrementableServices;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.bson.Document;

/**
 *
 * @author villa
 */
@RolesAllowed("admin")
@Path("/roles")
public class RolesResources {
    //@Inject
    //CollectionincrementableServices collectionincrementableServices;

    @Inject
    RolesRepository rolesRepository;

    @Inject
    AutoincrementableServices autoincrementableServices;

    @Inject
    CollectionincrementableServices collectionincrementableServices;

    //Mostrar todos
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Roles> todos() {
        return rolesRepository.findAll();
    }

    //Crear rol
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response agregarRol(Roles rol) {
        try {
            while (true) {
                rol.setIdRole(collectionincrementableServices.generate("Roles").getCount());
                if (rolesRepository.save(rol)) {
                    return Response.status(201).entity("Ok").build();
                } else {
                    if (rolesRepository.getException().getLocalizedMessage().toString().equals("A document with the primary key already exists.")) {
                        // aqui contar el ultimo y a partir de alli reinicar el conteo.
                    } else {
                        return Response.status(400).entity("Error " + rolesRepository.getException().getLocalizedMessage()).build();
                    }
                }
            }

        } catch (Exception e) {
            //JmoordbUtil.appendTextToLogErrorFile(this.directoryLogger, JmoordbUtil.nameOfClass(), JmoordbUtil.nameOfMethod(), e.getLocalizedMessage(), e);
            return Response.status(400).entity("Error!!" + e.getLocalizedMessage()).build();

        }
    }
    //Eliminar rol
    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response eliminarRol(@PathParam("id") String id) {
        try {
            if (rolesRepository.delete(new Document("idRole", id))) {
                return Response.status(201).entity("Se elimino el Rol: " + id).build();
            } else {
                return Response.status(400)
                        .entity(rolesRepository.getException().getLocalizedMessage()).build();
            }
        } catch (Exception e) {
            return Response.status(401).entity(e.getLocalizedMessage()).build();
        }
    }
    
    //Actualizar reporte
    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarRol(@PathParam("id") String id,Roles rol) {
        try {
            if (rolesRepository.update(rol)) {
                return Response.status(201).entity("Update Ok").build();
            } else {
                return Response.status(400)
                        .entity(rolesRepository.getException().getLocalizedMessage()).build();
            }
        } catch (Exception e) {
            return Response.status(401).entity(e.getLocalizedMessage()).build();
        }
    }
    
   
}
