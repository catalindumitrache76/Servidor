package main;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RepositorioUsuario {

	private Connection conexion = null;

	/**
	 * Metodo creador
	 */
	public RepositorioUsuario() {
		ConexionBD.iniciarConexion();
		this.conexion = ConexionBD.getConexion();
	}
	
	public Usuario findUsuario(String email) {
		Usuario usuario = null;
		try {
			String sql = "SELECT * FROM Usuario WHERE email='"+email+"'";
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.first();
			usuario = new Usuario(rs.getString("email"),rs.getString("nombre"),
					rs.getString("apellidos"),rs.getString("foto"),rs.getString("fecha_nacimiento"));
			stmt.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error en buscar Deporte");
		}
		return usuario;
	}
}