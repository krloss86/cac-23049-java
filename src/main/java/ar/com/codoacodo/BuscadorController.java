package ar.com.codoacodo;

import java.io.IOException;
import java.util.ArrayList;

import ar.com.codoacodo.dao.impl.DAO;
import ar.com.codoacodo.dao.impl.MySQLDAOImpl;
import ar.com.codoacodo.oop.Articulo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/BuscadorController")
public class BuscadorController extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String clave = req.getParameter("clave");

        //uso el dao
        DAO dao = new MySQLDAOImpl();

        //buscar
        try {
            ArrayList<Articulo> listado = dao.findAllByTitle(clave);

            req.setAttribute("listado",listado);

        } catch (Exception e) {
            req.setAttribute("listado",new ArrayList<>());
        }
        
        getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);//GET
    }
}
