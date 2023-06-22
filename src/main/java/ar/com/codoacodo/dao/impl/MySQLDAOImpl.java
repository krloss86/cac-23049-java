package ar.com.codoacodo.dao.impl;

import java.util.ArrayList;

import ar.com.codoacodo.oop.Articulo;
import ar.com.codoacodo.oop.Libro;

//cumplo el contrato
public class MySQLDAOImpl implements DAO {

    //atributos
    private String tableName = "articulo";


    //constructor 


    //metodos
    //va a cumplir ese contrato entre DAO y esta clase
    public Articulo getById(Long id) {//1
        return new Libro("","","",100,true,"1223123312");
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from articulos where id = " + id;
    }

    @Override
    public ArrayList<Articulo> findAll() {
        String sql = "select * from articulos";
        return null;
    }

    @Override
    public void update(Articulo articulo) {
        String sql = "update articulos set titulo= , precio= , autor= ";
    }

    @Override
    public void create(Articulo articulo) {
        String sql = "insert into articulos";
        sql += "(titulo,autor,precio,fecha,novedad) ";
        sql += "values (...,...,...,...,....) ";

        //Obtener la Conection

        //PreparedStatement con mi sql

        //RestultSet
    }    
}
