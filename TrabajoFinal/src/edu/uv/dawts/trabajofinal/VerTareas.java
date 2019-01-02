package edu.uv.dawts.trabajofinal;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VerTareas
 */
@WebServlet("/jefeproyecto/VerTareas")
public class VerTareas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VerTareas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher =  getServletContext(  ).getRequestDispatcher("/jefeproyecto/muestraTareas.jsp");
        dispatcher.forward(request, response); 
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		AccesoDatos ad = (AccesoDatos) getServletContext().getAttribute("bd");

		String proyectID = request.getParameter("id_pr");
		
		try {
			ArrayList<Proyecto> proyectos = ad.getAllProyectos();

			Proyecto proyecto = new Proyecto();
			for(int i = 0; i < proyectos.size(); i++) {
				if(proyectos.get(i).getId() == Integer.parseInt(proyectID))
					proyecto = proyectos.get(i);
			}
			request.setAttribute("proyecto", proyecto);
			
			ArrayList<Tarea> tareas = ad.getAllTareas(proyecto.getId());
			
			request.setAttribute("tareas", tareas);

			doGet(request,response);
			
		} catch (Exception ex) {
			request.setAttribute("msg",
					"Se ha producido un error interno al crear la tarea");
			getServletContext().getRequestDispatcher("/errorPage.jsp").forward(
					request, response);
		}
	}

}
