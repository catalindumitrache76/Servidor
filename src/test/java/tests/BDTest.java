package test.java.tests;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;

import main.java.modelo.Deporte;
import main.java.modelo.RepositorioComentario;
import main.java.modelo.RepositorioDeporte;
import main.java.modelo.RepositorioEvento;
import main.java.modelo.RepositorioMensaje;
import main.java.modelo.RepositorioUsuario;
import main.java.modelo.Usuario;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

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

	@Test
	public void AtestInsertarUsuario() {
		Usuario usuario = new Usuario("prueba","prueba3","prueba",
				"prueba", "1994-11-11", "prueba", "prueba");
		assertTrue(repoUsuario.insertarUsuario(usuario));
	}

	@Test
	public void testActualizarUsuario() {
		Usuario usuario = new Usuario("prueba","prueba","prueba",
				"prueba", "1994-12-06", "prueba", "prueba");
		assertTrue(repoUsuario.actualizarUsuario(usuario));
	}

	@Test
	public void testEliminarUsuario() {
		assertTrue(repoUsuario.borrarUsuario("prueba"));
	}

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
