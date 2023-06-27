//paquete: ar/com/codo
package ar.com.codoacodo;

import java.sql.SQLException;
import java.time.LocalDateTime;

import ar.com.codoacodo.dao.impl.DAO;
import ar.com.codoacodo.dao.impl.MySQLDAOImpl;
import ar.com.codoacodo.oop.Articulo;
import ar.com.codoacodo.oop.Libro;

//App.java = Clase java
public class AltaArticuloController {
    public static void main(String[] args) throws SQLException {
        
        //CREATE CONTROLLER 

        
        //tendria que tener los parametros del front (<form>)
        String titulo = "titulo del front";
        double precio = 1500;
        String autor  = "autor que viene en el form";
        String codigo  = "ABC123";
        String isbn  = "123465465456";
        LocalDateTime ldt = LocalDateTime.now();
        
        Articulo nuevo = new Libro(titulo, codigo, autor, precio, false, isbn);
        
        //Interface nombre  = new ClaseQueImplementaLaIntarface();
        DAO dao = new MySQLDAOImpl();
        
        //puedo usar lo metodos que tiene DAO, sin saber quien cumple el contrato
        try {
            dao.create(nuevo);
        } catch (Exception e) {
            e.printStackTrace();
        } //try/catch/finally

        System.out.println(nuevo);
    }
}
