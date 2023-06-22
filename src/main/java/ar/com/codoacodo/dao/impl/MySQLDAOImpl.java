package ar.com.codoacodo.dao.impl;

import java.util.ArrayList;

import ar.com.codoacodo.oop.Articulo;
import ar.com.codoacodo.oop.Libro;

//cumplo el contrato
public class MySQLDAOImpl implements DAO {

    //atributos
    private String tableName;

    //constructor 
    public MySQLDAOImpl()  {
        this.tableName = "articulos";
    }

    //metodos
    //va a cumplir ese contrato entre DAO y esta clase
    public Articulo getById(Long id) {//1
        return new Libro("","","",100,true,"1223123312");
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from "+this.tableName+" where id = " + id;
    }

    @Override
    public ArrayList<Articulo> findAll() {
        String sql = "select * from "+this.tableName+"";
        return null;
    }

    @Override
    public void update(Articulo articulo) {
        String sql = "update "+this.tableName+" set titulo= , precio= , autor= ";
    }

    @Override
    public void create(Articulo articulo) {
        String sql = "insert into "+this.tableName;
        sql += "(titulo,autor,precio,fecha,novedad) ";
        sql += "values (...,...,...,...,....) ";

        //Obtener la Conection

        //PreparedStatement con mi sql

        //RestultSet
    }    
}
