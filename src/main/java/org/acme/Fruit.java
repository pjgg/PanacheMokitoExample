package org.acme;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Fruit extends PanacheEntity {
    public String name;

    public static Fruit findByName(String name){
        return find("name", name).firstResult();
    }
}
