/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api.app.resources;

import com.mycompany.api.app.entitys.Usuario;
import com.mycompany.api.app.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
@Path("/usuario")
public class UsuarioResources {

    @Inject
    UsuarioRepository usuariorepository;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> todos() {
        return usuariorepository.findAll();
    }

    //Crear Usuario
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response agregarUsuario(Usuario usuario) {
        try {
            if (usuariorepository.save(usuario)) {
                return Response.status(201).entity("Se creo el Usuario").build();
            } else {
                return Response.status(400)
                        .entity(usuariorepository.getException().getLocalizedMessage()).build();
            }
        } catch (Exception e) {
            return Response.status(401).entity(e.getLocalizedMessage()).build();
        }
    }
    
    //Actualizar usuario
    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarUsuario(Usuario usuario) {
        try {
            if (usuariorepository.update(usuario)) {
                return Response.status(201).entity("Update Ok").build();
            } else {
                return Response.status(400)
                        .entity(usuariorepository.getException().getLocalizedMessage()).build();
            }
        } catch (Exception e) {
            return Response.status(401).entity(e.getLocalizedMessage()).build();
        }
    }
    
    //Eliminar usuario
    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response eliminarUsuario(@PathParam("id") String id) {
        try {
            if (usuariorepository.delete(new Document("identificador",id))) {
                return Response.status(201).entity("Se elimino el Usuario "+id).build();
            } else {
                return Response.status(400)
                        .entity(usuariorepository.getException().getLocalizedMessage()).build();
            }
        } catch (Exception e) {
            return Response.status(401).entity(e.getLocalizedMessage()).build();
        }
    }
    
    //Buscar usuario por ID
    @GET
    @Path("/search/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario buscarIdUsuario(@PathParam("id") String id) {
        Usuario usuario=new Usuario();
        try {    
            usuario.setIdentificador(id);
            Optional<Usuario> optional= usuariorepository.findById(usuario);
            if (optional.isPresent()) {
                return optional.get();
            } 
        } catch (Exception e) {
            System.out.print("error"+e.getLocalizedMessage());
        }
        return usuario;
    }

}
