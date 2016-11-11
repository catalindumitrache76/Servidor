package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;
import modelo.RepositorioUsuario;


/**
 * Servlet de obtencion de usuaiors
 */
@WebServlet(value = "/usuarios", name = "UsuariosServlet")
public class UsuariosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static RepositorioUsuario repo = new RepositorioUsuario();

	/**
	 * M�todo para a�adir usuarios a la BD a trav�s del cliente.
	 */
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String response = null;
		/*String email = (String) req.getAttribute("email");
		String nick = (String) req.getAttribute("nick");
		String nombre = (String) req.getAttribute("nombre");
		String apellidos = (String) req.getAttribute("apellidos");
		String contrasena = (String) req.getAttribute("contrasena");
		String foto = (String) req.getAttribute("foto");
		String fecha_nacimiento = (String) req.getAttribute("fecha_nacimiento");*/
		String email = req.getParameter("email");
		String nick = req.getParameter("nick");
		String nombre = req.getParameter("nombre");
		String apellidos = req.getParameter("apellidos");
		String contrasena = req.getParameter("contrasena");
		String foto = req.getParameter("foto");
		String fecha_nacimiento = req.getParameter("fecha_nacimiento");
		Usuario usuario = new Usuario(email,nombre,apellidos,contrasena,fecha_nacimiento,foto,nick);
		boolean realizado = repo.insertarUsuario(usuario);
		if (realizado) {
			resp.setStatus(HttpServletResponse.SC_OK);
			response = "El usuario se ha insertado correctamente";
		}
		else {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response = "El usuario no se ha podido insertar";
		}
		setResponse(response, resp);
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String response = null;
		String email = req.getParameter("email");
		String contrasena = req.getParameter("contrasena");
		/*String email = (String) req.getAttribute("email");
		String contrasena = (String) req.getAttribute("contrasena");*/
		Usuario usuario = repo.findUsuario(email);
		if (usuario != null && contrasena.equals(usuario.getContrasena())) {
			resp.setStatus(HttpServletResponse.SC_OK);
			response = "El usuario se ha logeado correctamente";
		}
		else {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response = "El usuario no se ha podido logear";
		}
		setResponse(response, resp);
	}

	/**
	 * Agrega una respuesta a la response
	 * 
	 * @param response
	 *            respuesta
	 * @param resp
	 *            response
	 */
	private void setResponse(String response, HttpServletResponse resp) {
		resp.setContentType("application/json");
		try {
			PrintWriter out = resp.getWriter();
			out.print(response);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}