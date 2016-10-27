package modelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


import baseDatos.ConexionBD;
public class RepositorioDeporte {

	private Connection conexion = null;

	/**
	 * Metodo creador
	 */
	public RepositorioDeporte() {
		ConexionBD.iniciarConexion();
		this.conexion = ConexionBD.getConexion();
	}

	public Deporte findDeporte(String nombre) {
		Deporte deporte = null;
		try {
			String sql = "SELECT * FROM Deporte WHERE Nombre='"+nombre+"'";
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.first();
			deporte = new Deporte(rs.getString("Nombre"));
			stmt.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error en buscar Deporte");
		}
		return deporte;
	}

	public List<Deporte> listarDeportes() {
		List<Deporte> deportes = new LinkedList<Deporte>();
		String sql = "SELECT * FROM Deporte";
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				deportes.add(new Deporte(rs.getString("Nombre")));
			}
			stmt.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error en listar Deportes");
		}
		return deportes;
	}

	public boolean suscribirseDeporte(String nombre, String email) {
		String sql = "INSERT INTO DeporteSuscrito (deporte,usuario)VALUES "
				+ "('"+nombre+"','"+email+"')";
		try {
			Statement stmt = conexion.createStatement();
			stmt.execute(sql);
			stmt.close();
			return true;
		}
		catch (SQLException e) {
			System.out.println("Error al suscribirse a deporte");
			return false;
		}
	}
}