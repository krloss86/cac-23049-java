package ar.com.codoacodo.dao.impl;

//JDBC
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
    public Articulo getById(Long id) throws Exception {//1
        String sql = "select * from "+this.tableName+" where id =?";

        //Obtener la Conection
        Connection con = AdministradorDeConexiones.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setLong(1,id);

        Articulo articulo = null;

        ResultSet res = pst.executeQuery();

        if(res.next()) {
            Long _id = res.getLong(1);
            String titulo = res.getString(2);
            String imagen = res.getString(3);
            String autor = res.getString(4);
            String novedad = res.getString(5);
            Date fechaCreacion = res.getDate(6);
            String codigo = res.getString(7);
            Double precio = res.getDouble(8);

            articulo = new Articulo(_id, titulo, imagen, autor, precio, false, codigo, LocalDateTime.now());
        }
        return articulo;
    }

    @Override
    public void delete(Long id) throws Exception {
        String sql = "delete from "+this.tableName+" where id = ? ";
        
        //Obtener la Conection
        Connection con = AdministradorDeConexiones.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setLong(1,id);

        pst.executeUpdate();
    }

    @Override
    public ArrayList<Articulo> findAll() throws Exception{
        String sql = "select * from "+this.tableName+"";

        //Obtener la Conection
        Connection con = AdministradorDeConexiones.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        ArrayList<Articulo> listado = new ArrayList<>();

        ResultSet res = pst.executeQuery();

        while(res.next()) {
            Long id = res.getLong(1);
            String titulo = res.getString(2);
            String imagen = res.getString(3);
            String autor = res.getString(4);
            String novedad = res.getString(5);
            Date fechaCreacion = res.getDate(6);
            String codigo = res.getString(7);
            Double precio = res.getDouble(8);

            listado.add(new Articulo(id, titulo, imagen, autor, 0, false, codigo, LocalDateTime.now()));
        }
        return listado;
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
        //sql injection!
        pst.setString(1,articulo.getTitulo());
        pst.setString(2,articulo.getAutor());
        pst.setDouble(3,articulo.getPrecio());
        pst.setDate(4, this.dateFrom(articulo.getFechaCreacion()));//fecha LocalDateTime > jdbc > java.sql.Date
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
