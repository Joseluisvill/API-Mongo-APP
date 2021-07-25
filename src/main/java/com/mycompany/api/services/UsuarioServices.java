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

import com.mycompany.api.app.encrypt.AES;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author villa
 */
@Stateless
public class UsuarioServices {

    @Inject
    UsuarioRepository usuariorepository;

    @Inject
    @ConfigProperty(name = "secretKey")
    private String secretKey;

    public UsuarioServices() {
    }

    public Usuario add(Usuario usuario) {
        usuario = Usuariodescrypt(usuario);
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

    public Usuario actualizar(Usuario usuario) {

        Usuario viejo = new Usuario();
        Usuario nuevo = new Usuario();
        String a, b;
        //nuevo=usuario;
        //desencrypto los nuevos datos recibido desde el cliente
        nuevo = Usuariodescrypt(usuario);
        Optional<Usuario> optional = usuariorepository.findById(nuevo);

        List<RolesAsignados> list = new ArrayList<RolesAsignados>();

        try {
            if (optional.isPresent()) {
                //obtengo el usuario anterior para actualizar los datos nuevos
                viejo = optional.get();
                System.out.println("Contrasena vieja:  " + viejo.getContrasena());
                //mantengo los roles con que contaba el usuario.
                list = viejo.getRoles();
                //agrego la lista de roles asignados al usuario a actualizar
                nuevo.setRoles(list);
                //verifico contraseña
                System.out.println(nuevo.getContrasena() + "  " + viejo.getContrasena());
                if (nuevo.getContrasena().equals(viejo.getContrasena())) {
                    System.out.println("Mantengo La vieja");
                    nuevo.setContrasena(viejo.getContrasena());
                } else {
                    System.out.println("Nueva " + nuevo.getContrasena());
                    nuevo.setContrasena(Encrypt.sha256(nuevo.getContrasena()));
                }
            }

        } catch (Exception e) {
            System.out.println("actualizarUsuario() " + e.getLocalizedMessage());
        }

        return nuevo;
    }

    public Usuario addUsuarioCaptador(Usuario usuario) {
        usuario = Usuariodescrypt(usuario);
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

    public List<Usuario> allActivos() {
        String query = "select * from Usuario where activo='" + true + "'";

        List<Usuario> list = usuariorepository.findBy(query);
        return list;
    }

    public Optional checkusuario(Usuario usuario) {

        usuario.setContrasena(AES.decrypt(usuario.getContrasena(), secretKey));
        usuario.setEmail(AES.decrypt(usuario.getEmail(), secretKey));

        //convierto el password a sha256
        String pass = usuario.getContrasena();
        usuario.setContrasena(Encrypt.sha256(pass));

        //String del query para la busqueda del usuario
        String query = "select * from Usuario where email='" + usuario.getEmail() + "' and contrasena='" + usuario.getContrasena() + "'";

        try {
            Optional<Usuario> optional = usuariorepository.findFirst(query);
            if (optional.isPresent()) {
                return optional;
            }
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

    public Usuario Usuariodescrypt(Usuario usuario) {
        //Desencripto los valores que recibo del cliente
        usuario.setIdentificador(AES.decrypt(usuario.getIdentificador(), secretKey));
        usuario.setContrasena(AES.decrypt(usuario.getContrasena(), secretKey));
        usuario.setEmail(AES.decrypt(usuario.getEmail(), secretKey));
        usuario.setNombre(AES.decrypt(usuario.getNombre(), secretKey));
        usuario.setTelefono(AES.decrypt(usuario.getTelefono(), secretKey));

        return usuario;
    }

}
