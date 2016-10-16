package main;

public class Usuario {

	private String email;
	private String nick;
	private String nombre;
	private String apellidos;
	private String foto;
	private String fecha_nacimiento;

	public Usuario(String email, String nick, String nombre, String apellidos,
			String foto, String fecha_nacimiento) {
		this.email=email;
		this.nick=nick;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.foto=foto;
		this.fecha_nacimiento=fecha_nacimiento;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
}