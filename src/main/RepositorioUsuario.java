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
		String sql = "SELECT * FROM Usuario WHERE email='"+email+"'";
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.first();
			usuario = new Usuario(rs.getString("email"),rs.getString("nick"),rs.getString("nombre"),
					rs.getString("apellidos"),rs.getString("contrasena"),rs.getString("foto"),rs.getString("fecha_nacimiento"));
			stmt.close();
		}
		catch (SQLException e) {
			System.out.println("Error en buscar Usuario");
		}
		return usuario;
	}

	public boolean insertarUsuario(Usuario usuario) {
		String sql = "INSERT INTO Usuario (email,nick,nombre,apellidos,contrasena,foto,"
				+ "fecha_nacimiento)VALUES "
				+ "('"+usuario.getEmail()+"','"+usuario.getNombre()+"','"+usuario.getApellidos()+"','"+usuario.getContrasena()+"','"+usuario.getFoto()+"','"+usuario.getFecha_nacimiento()+"')";
		try {
			Statement stmt = conexion.createStatement();
			stmt.execute(sql);
			stmt.close();
			return true;
		}
		catch (SQLException e) {
			System.out.println("Error al insertar usuario");
			return false;
		}
	}

	public boolean borrarUsuario(String email) {
		String sql = "DELETE FROM Usuario WHERE email='"+email+"'";
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeQuery(sql);
			stmt.close();
			return true;
		}
		catch (SQLException e) {
			System.out.println("Error al borrar usuario");
			return false;
		}
	}

	public boolean actualizarUsuario (Usuario usuario) {
		String sql = "UPDATE Usuario SET nick="+usuario.getNick()+", nombre="+usuario.getNombre()+","
				+ "apellidos="+usuario.getApellidos()+", contrasena="+usuario.getContrasena()+", foto="+usuario.getFoto()+","
				+ " fecha_nacimiento="+usuario.getFecha_nacimiento()+" "
				+ "WHERE email='"+usuario.getEmail()+"'";
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeQuery(sql);
			stmt.close();
			return true;
		}
		catch (SQLException e) {
			System.out.println("Error al actualizar usuario");
			return false;
		}
	}
}