package main.java.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.modelo.Deporte;
import main.java.modelo.RepositorioDeporte;

/**
 * Servlet de obtencion de usuaiors
 */
@WebServlet(value = "/deportes", name = "DeportesServlet")
public class DeportesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static RepositorioDeporte repoDeporte = new RepositorioDeporte();

	/**
	 * M�todo para a�adir usuarios a la BD a trav�s del cliente.
	 */
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String response = null;
		List<Deporte> deportes = null;
		String email = req.getParameter("email");
		if (email == null) {
			deportes = repoDeporte.listarDeportes();
			response = "todos los deportes";
		}
		else {
			deportes = repoDeporte.listarDeportesUsuario(email);
			response = "deportes usuario";
		}
		if (deportes==null) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response = "El usuario no existe";
		}
		else {
			resp.setStatus(HttpServletResponse.SC_OK);
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