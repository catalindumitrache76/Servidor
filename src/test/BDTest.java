package test;
import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.Test;

import main.RepositorioComentario;
import main.RepositorioDeporte;
import main.RepositorioEvento;
import main.RepositorioUsuario;

public class BDTest {
	
	private static RepositorioDeporte repoDeporte;
	private static RepositorioUsuario repoUsuario;
	private static RepositorioComentario repoComentario;
	private static RepositorioEvento repoEvento;
	
	@BeforeClass
	public static void setUp() {
		repoDeporte = new RepositorioDeporte();
		repoUsuario = new RepositorioUsuario();
		repoComentario = new RepositorioComentario();
		repoEvento = new RepositorioEvento();
	}
	
	@Test
	public void testFindDeporte() {
		assertEquals(repoDeporte.findDeporte("prueba").getNombre(), "prueba");
	}
	
	@Test
	public void testFindUsuario() {
		assertEquals(repoDeporte.findDeporte("prueba").getNombre(), "prueba");
	}	
	
	@Test
	public void testFindComentario() {
		assertEquals(repoDeporte.findDeporte("prueba").getNombre(), "prueba");
	}	
	
	@Test
	public void testFindEvento() {
		assertEquals(repoDeporte.findDeporte("prueba").getNombre(), "prueba");
	}	
}
