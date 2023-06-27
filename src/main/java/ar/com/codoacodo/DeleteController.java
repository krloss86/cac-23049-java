package ar.com.codoacodo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.dao.impl.DAO;
import ar.com.codoacodo.dao.impl.MySQLDAOImpl;

public class DeleteController extends HttpServlet {
    
    //esto lo maneja el servidor (Tomcat)
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String id = req.getParameter("id");
    
        DAO dao = new MySQLDAOImpl();
        
        try {
            dao.delete(Long.parseLong(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
