package ar.com.codoacodo.dao.impl;

import java.util.ArrayList;

import ar.com.codoacodo.oop.Articulo;

//el contrato es DAO
//no se pueden instanciar
public interface DAO {
 
    //el que debe hacer el que quiera usar el contrato DAO
    public Articulo getById(Long id);//LA PK DE LA TABLA
    public void delete(Long id);//LA PK DE LA TABLA
    public ArrayList<Articulo> findAll();
    public void update(Articulo articulo);//TIENE ID
    public void create(Articulo articulo);//NO TIENE ID
}
