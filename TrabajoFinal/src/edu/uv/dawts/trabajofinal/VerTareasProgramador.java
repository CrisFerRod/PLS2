package edu.uv.dawts.trabajofinal;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VerProyectos
 */
@WebServlet("/programador/VerTareasProgramador")
public class VerTareasProgramador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VerTareasProgramador() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		AccesoDatos ad = (AccesoDatos) getServletContext().getAttribute("bd");

		String programador = request.getParameter("programador");
		
		try {
			ArrayList<Tarea> tareas = ad.getTareasUsuario(programador);

			request.setAttribute("tareas", tareas);
			
			request.setAttribute("programador", programador);

			getServletContext().getRequestDispatcher(
					"/programador/muestraTareasProgramador.jsp").forward(request,
					response);
		} catch (Exception ex) {
			request.setAttribute("msg",
					"Se ha producido un error interno al cargar las Tareas");
			getServletContext().getRequestDispatcher("/errorPage.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
