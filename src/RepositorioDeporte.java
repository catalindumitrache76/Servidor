import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RepositorioDeporte {

	private Connection conexion = null;

	/**
	 * Metodo creador
	 */
	public RepositorioDeporte() {
		ConexionBD.iniciarConexion();
		this.conexion = ConexionBD.getConexion();
	}

	public String findDeporte(String nombre) {
		String deporte = null;
		try {
			String sql = "SELECT * FROM Deporte WHERE nombre="+nombre;
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			deporte = rs.getString("nombre");
			stmt.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error en buscar Deporte");
		}
		return deporte;
	}
}
