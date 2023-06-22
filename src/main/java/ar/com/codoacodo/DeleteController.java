package ar.com.codoacodo;

import ar.com.codoacodo.dao.impl.DAO;
import ar.com.codoacodo.dao.impl.MySQLDAOImpl;

public class DeleteController {
    
    public static void main(String[] args) {

        long id = 10;

        DAO dao = new MySQLDAOImpl();
        
        dao.delete(id);
    }
}
