package main;

public class Evento {
	private int id;
	private String fecha;
	private String hora;
	private String deporte;
	private String creador;

	public Evento(int id, String fecha, String hora, String deporte, String creador) {
		this.id=id;
		this.fecha=fecha;
		this.hora=hora;
		this.deporte=deporte;
		this.creador=creador;
	}

	public Evento(String fecha, String hora, String deporte, String creador) {
		this.fecha=fecha;
		this.hora=hora;
		this.deporte=deporte;
		this.creador=creador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}
}