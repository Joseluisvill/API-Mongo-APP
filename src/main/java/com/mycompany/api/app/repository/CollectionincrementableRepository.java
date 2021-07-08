/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api.app.repository;

import com.avbravo.jmoordb.mongodb.repository.Repository;
import com.mycompany.api.app.entitys.Collectionincrementable;
import javax.ejb.Stateless;

@Stateless
public class CollectionincrementableRepository extends Repository<Collectionincrementable> {

    public CollectionincrementableRepository(){
        super(Collectionincrementable.class,"App","collectionincrementable");
    }
}