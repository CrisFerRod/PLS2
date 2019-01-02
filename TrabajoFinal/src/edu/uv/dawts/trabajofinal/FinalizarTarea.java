package edu.uv.dawts.trabajofinal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class AddProyecto
 */
@WebServlet("/programador/FinalizarTarea")
public class FinalizarTarea extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FinalizarTarea() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id_tarea = request.getParameter("id_tarea");
		String programador = request.getParameter("programador");
		
		AccesoDatos ad = (AccesoDatos) getServletContext().getAttribute("bd");

		try {
			ArrayList<Tarea> tareas = ad.getTareasUsuario(programador);
			boolean finalizar = false;
			for(int i = 0; i < tareas.size(); i++) {
				if(tareas.get(i).getId() == Integer.parseInt(id_tarea))
					if(tareas.get(i).getFechaFinalizacion() == null)
						finalizar = true;
			}
			if(finalizar) {
				Calendar c = Calendar.getInstance();
				ad.setFechaFinalizacion(c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1, c.get(Calendar.DAY_OF_MONTH), Integer.parseInt(id_tarea));
			}

			tareas = ad.getTareasUsuario(programador);
			request.setAttribute("tareas", tareas);
			request.setAttribute("programador", programador);
			
			getServletContext().getRequestDispatcher(
					"/programador/muestraTareasProgramador.jsp").forward(request,
					response);
		} catch (Exception ex) {
			request.setAttribute("msg",
					"Se ha producido un error interno al finalizar la tarea");
			getServletContext().getRequestDispatcher("/errorPage.jsp").forward(
					request, response);
		}

	}

}
