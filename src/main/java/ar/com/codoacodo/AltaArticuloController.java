//paquete: ar/com/codo
package ar.com.codoacodo;

import java.io.IOException;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import ar.com.codoacodo.dao.impl.DAO;
import ar.com.codoacodo.dao.impl.MySQLDAOImpl;
import ar.com.codoacodo.oop.Articulo;
import ar.com.codoacodo.oop.Libro;

//App.java = Clase java
@WebServlet("/AltaArticuloController")
public class AltaArticuloController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //CREATE CONTROLLER 
        System.out.println("AltaArticuloController");
        //tendria que tener los parametros del front (<form>)
        String titulo = req.getParameter("nombre");
        double precio = Double.parseDouble(req.getParameter("precio"));
        String autor  = req.getParameter("autor");
        String codigo  = req.getParameter("codigo");
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
