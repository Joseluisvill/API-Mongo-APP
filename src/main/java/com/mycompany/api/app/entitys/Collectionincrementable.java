/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api.app.entitys;

import com.avbravo.jmoordb.anotations.Id;
import javax.ejb.Stateless;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 *
 * @author villa
 */
public class Collectionincrementable {
    @Id
   private String collections;
   private Integer count;

    public Collectionincrementable() {
    }

    public Collectionincrementable(String collections, Integer count) {
        this.collections = collections;
        this.count = count;
    }

    public String getCollections() {
        return collections;
    }

    public void setCollections(String collections) {
        this.collections = collections;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
   
   
   @Override
    public boolean equals(Object object) {
        if (!(object instanceof Collectionincrementable)) {
            return false;
        }
       Collectionincrementable  other = (Collectionincrementable) object;
        if ((this.collections == null && other.collections != null) || (this.collections != null && !this.collections.equals(other.collections))) {
            return false;
        }
          return true;
    }
   
    public boolean equalsReflection(Object object) {
        if (!(object instanceof Collectionincrementable)) {
            return false;
        }
       Collectionincrementable  other = (Collectionincrementable) object;
        if ((this.collections == null && other.collections != null) || (this.collections != null && !this.collections.equals(other.collections))) {
            return false;
        }
          return EqualsBuilder.reflectionEquals(this, object);
    }

}
