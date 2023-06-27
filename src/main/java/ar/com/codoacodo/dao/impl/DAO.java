package ar.com.codoacodo.dao.impl;

import java.util.ArrayList;

import ar.com.codoacodo.oop.Articulo;

//el contrato es DAO
//no se pueden instanciar
public interface DAO {
 
    //el que debe hacer el que quiera usar el contrato DAO
    public Articulo getById(Long id) throws Exception;//LA PK DE LA TABLA
    public void delete(Long id) throws Exception;//LA PK DE LA TABLA
    public ArrayList<Articulo> findAll() throws Exception;
    public void update(Articulo articulo) throws Exception;//TIENE ID
    public void create(Articulo articulo) throws Exception;//NO TIENE ID
}
