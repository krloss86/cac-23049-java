package ar.com.codoacodo;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import ar.com.codoacodo.dao.impl.DAO;
import ar.com.codoacodo.dao.impl.MySQLDAOImpl;

@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {

    // esto lo maneja el servidor (Tomcat)
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        DAO dao = new MySQLDAOImpl();

        try {
            // success
            dao.delete(Long.parseLong(id));

            req.setAttribute("success", "Se ha eliminado el articulo");
        } catch (Exception e) {
            // error
            req.setAttribute("error", "No se ha eliminado el articulo");
            e.printStackTrace();
        }

        // redirect
        getServletContext().getRequestDispatcher("/ListadoArticuloController").forward(req, resp);//GET
    }
    /*
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    */
}
