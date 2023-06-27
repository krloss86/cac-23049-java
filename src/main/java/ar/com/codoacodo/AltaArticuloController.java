//paquete: ar/com/codo
package ar.com.codoacodo;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.dao.impl.DAO;
import ar.com.codoacodo.dao.impl.MySQLDAOImpl;
import ar.com.codoacodo.oop.Articulo;
import ar.com.codoacodo.oop.Libro;

//App.java = Clase java
public class AltaArticuloController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //CREATE CONTROLLER 
        
        //tendria que tener los parametros del front (<form>)
        String titulo = "titulo del front";
        double precio = 1500;
        String autor  = "autor que viene en el form";
        String codigo  = "ABC124";
        String isbn  = "123465465456";
        LocalDateTime fechaCreacion = LocalDateTime.now();
        
        Articulo nuevo = new Libro(titulo, codigo, autor, precio, false, isbn,codigo,fechaCreacion);
        
        //Interface nombre  = new ClaseQueImplementaLaIntarface();
        DAO dao = new MySQLDAOImpl();
        
        //puedo usar lo metodos que tiene DAO, sin saber quien cumple el contrato
        try {
            dao.create(nuevo);
        } catch (Exception e) {
            e.printStackTrace();
        } //try/catch/finally
    }
}
