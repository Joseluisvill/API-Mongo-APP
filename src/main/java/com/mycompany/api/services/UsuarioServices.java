/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api.services;

import com.mycompany.api.app.encrypt.Encrypt;
import com.mycompany.api.app.entitys.RolesAsignados;
import com.mycompany.api.app.entitys.Usuario;
import com.mycompany.api.app.repository.UsuarioRepository;
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
public class UsuarioServices {

    @Inject
    UsuarioRepository usuariorepository;

    public UsuarioServices() {
    }

    public Usuario add(Usuario usuario) {

        try {
            String pass = usuario.getContrasena();
            usuario.setContrasena(Encrypt.sha256(pass));
            //por defecto estara activo desde que se crea el usuario
            usuario.setActivo(true);
            return usuario;

        } catch (Exception e) {
            System.out.println("add() " + e.getLocalizedMessage());
        }

        return usuario;
    }

    public Usuario actulizar(Usuario usuario) {
        Usuario u = new Usuario();
        u.setIdentificador(usuario.getIdentificador());
        Optional<Usuario> optional = usuariorepository.findById(u);
        List<RolesAsignados> list = new ArrayList<RolesAsignados>();

        String pass;
        try {
            if (optional.isPresent()) {
                //obtengo el usuario anterior para actualizar los datos nuevos
                u = optional.get();
                System.out.println(optional.get());
                //mantengo los roles con que contaba el usuario.
                list = u.getRoles();
                //agrego la lista de roles asignados al usuario a actualizar
                usuario.setRoles(list);
                pass = usuario.getContrasena();
                if (!pass.isEmpty()) {
                    usuario.setContrasena(Encrypt.sha256(pass));
                }
            }

        } catch (Exception e) {
            System.out.println("actualizarUsuario() " + e.getLocalizedMessage());
        }

        return usuario;
    }

    public Usuario addUsuarioCaptador(Usuario usuario) {
        List<RolesAsignados> list = new ArrayList<RolesAsignados>();
        try {
            //id del captador es 3
            RolesAsignados rolAsig = new RolesAsignados();
            rolAsig.setIdRole(3);
            rolAsig.setActivo(true);

            //activarlo por defecto
            usuario.setActivo(true);

            //asigno el rol a la lista de roles asignaciones
            list.add(rolAsig);

            //agrego la lista al usuario
            usuario.setRoles(list);
            String pass = usuario.getContrasena();
            usuario.setContrasena(Encrypt.sha256(pass));
        } catch (Exception e) {
            System.out.println("addUsuarioCaptador() " + e.getLocalizedMessage());
        }

        return usuario;
    }

    public Optional checkusuario(Usuario usuario) {

        try {
            //convierto el password a sha256
            String pass = usuario.getContrasena();
            usuario.setContrasena(Encrypt.sha256(pass));

            //String del query para la busqueda del usuario
            String query = "select * from Usuario where email='" + usuario.getEmail() + "' and contrasena='" + usuario.getContrasena() + "'";

            Optional<Usuario> optional = usuariorepository.findFirst(query);
            return optional;

        } catch (Exception e) {
            System.out.println("checkusuario() " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }

    public Usuario addRol(String idUsuario, int idRole) {
        Usuario usuario = new Usuario();
        usuario.setIdentificador(idUsuario);

        List<RolesAsignados> list = new ArrayList<RolesAsignados>();

        Optional<Usuario> optional = usuariorepository.findById(usuario);
        try {
            if (optional.isPresent()) {
                //introduzco el id del rol y por defecto estara true el rol asignado
                RolesAsignados rolAsig = new RolesAsignados();
                rolAsig.setIdRole(idRole);
                rolAsig.setActivo(true);

                //Asigno todos los datos al usario
                usuario = optional.get();
                //Asigno el valor del rol
                list = usuario.getRoles();

                //asigno el rol a la lista de roles asignaciones
                list.add(rolAsig);

                //agreo los roles al usuario
                usuario.setRoles(list);

                return usuario;
            }
        } catch (Exception e) {
            System.out.println("addRol() " + e.getLocalizedMessage());
        }

        return usuario;
    }

}
