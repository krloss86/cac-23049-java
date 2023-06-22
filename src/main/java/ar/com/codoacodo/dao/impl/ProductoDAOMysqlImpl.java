package ar.com.codoacodo.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.codoacodo.db.AdministradorDeConexiones;
import ar.com.codoacodo.oop.Articulo;


public class ProductoDAOMysqlImpl {

	public Articulo getById(Long id) throws Exception {

		// 1 - necesito la Connection
		Connection connection = AdministradorDeConexiones.getConnection();

		// 2 - arma el statement
		String sql = "SELECT * FROM Articulo WHERE ID = " + id;
		Statement statement = connection.createStatement();

		// 3 - resultset
		ResultSet resultSet = statement.executeQuery(sql);

		// verifico si hay datos
		if (resultSet.next()) {
			Articulo p = this.crearArticulo(resultSet);
			cerrar(connection);
			return p;
		}
		
		// flata cerrar la connection!!!
		return null;
	}

	private void cerrar(Connection con) throws Exception{
		con.close();
	}
	
	
	public List<Articulo> findAll() throws Exception {
		// 1 - necesito la Connection
		Connection connection = AdministradorDeConexiones.getConnection();

		// 2 - arma el statement
		String sql = "SELECT * FROM Articulo";
		Statement statement = connection.createStatement();

		// 3 - resultset
		ResultSet resultSet = statement.executeQuery(sql);

		// Interface i = new ClaseQueImplementaLaInterface();
		List<Articulo> Articulos = new ArrayList<Articulo>();

		// verifico si hay datos
		while (resultSet.next()) {
			Articulos.add(this.crearArticulo(resultSet));
		}
		
		cerrar(connection);
		
		return Articulos;
	}

	
	public void delete(Long id) throws Exception{
		// 1 - necesito la Connection
		Connection connection = AdministradorDeConexiones.getConnection();

		// 2 - arma el statement
		String sql = "DELETE FROM Articulo WHERE ID="+id;
		Statement statement = connection.createStatement();

		// 3 - resultset
		int eliminado = statement.executeUpdate(sql);//1 o 2
		
		cerrar(connection);
		System.out.println(eliminado);
	}

	
	public void update(Articulo articulo) throws Exception {
		
		// 1 - necesito la Connection
		Connection connection = AdministradorDeConexiones.getConnection();

		// 2 - arma el statement
		String sql = "UPDATE Articulo set titulo=?, precio=?, autor=?, img=? WHERE id=?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		//cambiar los ? por el tipo de dato y su valor
		statement.setString(1,articulo.getTitulo());
		statement.setDouble(2,articulo.getPrecio());
		statement.setString(3,articulo.getAutor());
		statement.setString(4,articulo.getImg());
		statement.setLong(5,articulo.getId());
		
		statement.execute();
		
		cerrar(connection);
	}

	
	public void create(Articulo Articulo) throws Exception {//alt+shift+r
		// 1 - necesito la Connection
		Connection connection = AdministradorDeConexiones.getConnection();

		// 2 - arma el statement															  1 2 3 4 5 6
		String sql = "INSERT INTO Articulo (codigo,titulo,precio,fecha_alta,autor,img) values(?,?,?,?,?,?)" ;
		
		PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		//cambiar los ? por el tipo de dato y su valor
		statement.setString(1,Articulo.getCodigo());
		statement.setString(2,Articulo.getTitulo()); 
		statement.setDouble(3,Articulo.getPrecio());
		statement.setDate(4, new java.sql.Date(Articulo.getFechaAlta().getTime()));
		statement.setString(5,Articulo.getAutor());
		statement.setString(6,Articulo.getImg());
		
		statement.execute();
		
		ResultSet res = statement.getGeneratedKeys();//me retorna la clave generada
		
		if(res.next()) {
			Articulo.setId(res.getLong(1));
		}
		
		cerrar(connection);
	}

	private Articulo crearArticulo(ResultSet resultSet) throws Exception {
		// obtengo el dato del campo id
		Long idDb = resultSet.getLong("id");
		String codigo = resultSet.getString("codigo");
		String titulo = resultSet.getString("titulo");
		Double precio = resultSet.getDouble("precio");
		Date fechaAlta = resultSet.getDate("fecha_alta");
		String autor = resultSet.getString("autor");
		String img = resultSet.getString("img");

		return new Articulo(idDb, codigo, titulo, precio, fechaAlta, autor, img);
	}

	
	public List<Articulo> search(String clave) throws Exception {
		// 1 - necesito la Connection
		Connection connection = AdministradorDeConexiones.getConnection();

		// 2 - arma el statement
		String sql = "SELECT * FROM Articulo WHERE TITULO LIKE ?";
		PreparedStatement statement = connection.prepareStatement(sql);

		//setear el valor que va en remplazo del ?
		statement.setString(1, "%" + clave + "%");
		
		// 3 - resultset
		ResultSet resultSet = statement.executeQuery();

		// Interface i = new ClaseQueImplementaLaInterface();
		List<Articulo> Articulos = new ArrayList<Articulo>();

		// verifico si hay datos
		while (resultSet.next()) {
			Articulos.add(this.crearArticulo(resultSet));
		}
		
		cerrar(connection);
		
		return Articulos;
	}
}
