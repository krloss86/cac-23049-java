package ar.com.codoacodo.dao.impl;

//JDBC
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

import ar.com.codoacodo.db.AdministradorDeConexiones;
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
        return null;
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from "+this.tableName+" where id = " + id;
        //aca va la magia que falta!!
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
    public void create(Articulo articulo) throws Exception {
        String sql = "insert into "+this.tableName;
        sql += "(titulo,autor,precio,fecha_creacion,novedad,codigo) ";
        sql += "values (?,?,?,?,?,?) ";
//                      1 2 3 4 5
         //Obtener la Conection
        Connection con = AdministradorDeConexiones.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1,articulo.getTitulo());
        pst.setString(2,articulo.getAutor());
        pst.setDouble(3,articulo.getPrecio());
        pst.setDate(4, this.dateFrom(articulo.getFechaCrecion()));//fecha LocalDateTime > jdbc > java.sql.Date
        pst.setInt(5,articulo.isNovedad() ? 1 : 0);        
        pst.setString(6,articulo.getCodigo());        

        //RestultSet
        pst.executeUpdate();//INSERT/UPDATE/DELETE
    }    

    private Date dateFrom(LocalDateTime ldt) {
        java.util.Date date = Date.from(ldt.toLocalDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        return new java.sql.Date(date.getTime());

        //Calendar
        //Gregorian Calendar
    }
}
