package tests;

import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;  // for non-hamcrest core matchers
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import controlador.UsuariosServlet;
import modelo.RepositorioUsuario;

public class UsuariosServletTest {

	private UsuariosServlet servlet;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private StringWriter response_writer;
	private Map<String, String> parameters;

	@Before
	public void setUp() throws IOException {
		parameters = new HashMap<String, String>();
		servlet = new UsuariosServlet();
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		response_writer = new StringWriter();

		when(request.getParameter(anyString())).thenAnswer(new Answer<String>() {
			public String answer(InvocationOnMock invocation) {
				return parameters.get((String) invocation.getArguments()[0]);
			}
		});
		when(response.getWriter()).thenReturn(new PrintWriter(response_writer));
	}

	@Test
	public void testGetErroneo() throws Exception {
		parameters.put("email", "asd");
		parameters.put("contrasena", "asdafgh");
		servlet.doGet(request, response);
		assertEquals(response_writer.toString(),"El usuario no se ha podido logear");
	}
	
	@Test
	public void testGetOK() throws Exception {
		parameters.put("email", "test");
		parameters.put("contrasena", "test");
		servlet.doGet(request, response);
		assertEquals(response_writer.toString(),"El usuario se ha logeado correctamente");
	}
	
	
	@Test
	public void testPostOK() throws Exception {
		parameters.put("email", "try");
		parameters.put("nombre", "try");
		parameters.put("apellidos", "try");
		parameters.put("contrasena", "try");
		parameters.put("foto", "try");
		parameters.put("fecha_nacimiento", "1900-10-10");
		parameters.put("nick", "try");
		servlet.doPost(request, response);
		assertEquals(response_writer.toString(),"El usuario se ha insertado correctamente");
	}
	
	@Test
	public void testPostErroneo() throws Exception {
		parameters.put("email", "try");
		parameters.put("nombre", "try");
		parameters.put("apellidos", "try");
		parameters.put("contrasena", "try");
		parameters.put("foto", "try");
		parameters.put("fecha_nacimiento", "deberianserunosnumeros");
		parameters.put("nick", "try");
		RepositorioUsuario repoUsuario = new RepositorioUsuario();
		//borramos porque el usuario ya existe de test anteriores
		repoUsuario.borrarUsuario("try");
		servlet.doPost(request, response);
		assertEquals(response_writer.toString(),"El usuario no se ha podido insertar");
	}
}