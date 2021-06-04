package com.choirula.h2database.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Person implements Serializable {   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name,address;

    public Person(){

    }

    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }

    public Person(Long id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    @Override
    public String toString(){
        return "Person{"+ "id="+id+", name='"+name+'\''+", address='"+address+'\''+'}';
    }
}
