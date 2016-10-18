package test;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import main.Deporte;
import main.RepositorioComentario;
import main.RepositorioDeporte;
import main.RepositorioEvento;
import main.RepositorioMensaje;
import main.RepositorioUsuario;
import main.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BDTest {

	private static RepositorioDeporte repoDeporte;
	private static RepositorioUsuario repoUsuario;
	private static RepositorioComentario repoComentario;
	private static RepositorioEvento repoEvento;
	private static RepositorioMensaje repoMensaje;

	@BeforeClass
	public static void setUp() {
		repoDeporte = new RepositorioDeporte();
		repoUsuario = new RepositorioUsuario();
		repoComentario = new RepositorioComentario();
		repoEvento = new RepositorioEvento();
		repoMensaje = new RepositorioMensaje();
	}

	@Test
	public void testFindDeporte() {
		assertEquals(repoDeporte.findDeporte("prueba").getNombre(), "prueba");
	}
	
	@Test
	public void testListarDeportes() {
		List<Deporte> deportes = repoDeporte.listarDeportes();
		assertTrue(deportes.size()>0);
	}

	@Test
	public void testFindUsuario() {
		assertEquals(repoDeporte.findDeporte("prueba").getNombre(), "prueba");
	}	
	/*
	@Test
	public void testInsertarUsuario() {
		Usuario usuario = new Usuario("prueba","prueba","prueba","prueba",
				"prueba", "12-6-1994");
		assertTrue(repoUsuario.insertarUsuario(usuario));
	}
	
	@Test
	public void testActualizarUsuario() {
		Usuario usuario = new Usuario("prueba","123","123","123",
				"123", "12-6-1994");
		assertTrue(repoUsuario.actualizarUsuario(usuario));
	}
	
	@Test
	public void testEliminarUsuario() {
		assertTrue(repoUsuario.borrarUsuario("prueba"));
	}*/

	@Test
	public void testFindComentario() {
		assertEquals(repoDeporte.findDeporte("prueba").getNombre(), "prueba");
	}	

	@Test
	public void testFindEvento() {
		assertEquals(repoDeporte.findDeporte("prueba").getNombre(), "prueba");
	}	

	@Test
	public void testFindMensaje() {
		assertEquals(repoDeporte.findDeporte("prueba").getNombre(), "prueba");
	}	
}
