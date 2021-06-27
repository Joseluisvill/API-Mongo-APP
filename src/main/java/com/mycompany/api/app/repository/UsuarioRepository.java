/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api.app.repository;

import com.avbravo.jmoordb.mongodb.repository.Repository;
import com.mycompany.api.app.entitys.Usuario;
import javax.ejb.Stateless;

/**
 *
 * @author villa
 */
@Stateless
public class UsuarioRepository extends Repository<Usuario>{
    public UsuarioRepository(){
        super(Usuario.class,"App","Usuario");
    }
}
