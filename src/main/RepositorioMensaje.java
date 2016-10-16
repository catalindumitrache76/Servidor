package main;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RepositorioMensaje {

	private Connection conexion = null;

	/**
	 * Metodo creador
	 */
	public RepositorioMensaje() {
		ConexionBD.iniciarConexion();
		this.conexion = ConexionBD.getConexion();
	}

	public Mensaje findMensaje(int id) {
		Mensaje mensaje = null;
		try {
			String sql = "SELECT * FROM Mensaje WHERE id='"+id+"'";
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.first();
			mensaje = new Mensaje(rs.getInt("id"),rs.getString("fecha"),rs.getString("hora"),
					rs.getString("texto"),rs.getString("autor"),rs.getString("destinatario"));
			stmt.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error en buscar Deporte");
		}
		return mensaje;
	}
}