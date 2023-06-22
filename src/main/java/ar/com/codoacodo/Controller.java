//paquete: ar/com/codo
package ar.com.codoacodo;

import java.sql.SQLException;
import java.time.LocalDateTime;

import ar.com.codoacodo.dao.impl.DAO;
import ar.com.codoacodo.dao.impl.MySQLDAOImpl;
import ar.com.codoacodo.oop.Articulo;

//App.java = Clase java
public class Controller {
    public static void main(String[] args) throws SQLException {
        
        //Interface nombre  = new ClaseQueImplementaLaIntarface();
        DAO dao = new MySQLDAOImpl();
        
        //tendria que tener los parametros del front (<form>)
        String titulo = "titulo del front";
        double precio = 1500;
        String autor  = "autor que viene en el form";
        String codigo  = "ABC123";
        String isbn  = "123465465456";
        LocalDateTime ldt = LocalDateTime.now();
        
        //puedo usar lo metodos que tiene DAO, sin saber quien cumple el contrato
        Articulo a = dao.getById(1l);

        System.out.println(a);
    }
}
