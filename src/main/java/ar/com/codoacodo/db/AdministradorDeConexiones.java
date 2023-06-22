package ar.com.codoacodo.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexiones {

	/*static permite usar Clase.metodo 
	 * AdministradorDeConexiones.getConnection()
	 * sin necesidad  de instanciar un objeto
	*/
	public static Connection getConnection() {
		String hosts = "127.0.0.1";//localhost
		String port = "33060";
		String password = "secret";
		String username = "root";
		
		//driver de conexion a la base de datos
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		
		//nombre de la base de datos
		String dbName = "23049-db";
		
		//NO VOY A EXPLICAR TRY CATCH, SOLO LO VAMOS A USAR
		Connection connection;
		try {
			Class.forName(driverClassName);
			
			String url = "jdbc:mysql://" + hosts + ":"+ port +"/"+ dbName +"?allowPublicKeyRetrieval=true&serverTimeZone=UTC&useSSL=false";
			
			connection = DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			connection = null;
		}
		
		return connection;
	}
}
