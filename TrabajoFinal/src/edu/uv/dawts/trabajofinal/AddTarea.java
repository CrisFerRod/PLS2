package edu.uv.dawts.trabajofinal;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddTarea
 */
@WebServlet("/jefeproyecto/AddTarea")
public class AddTarea extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTarea() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreTarea = request.getParameter("nombre");
		String programador = request.getParameter("programador");
		String anyo = request.getParameter("anyo");
		String mes = request.getParameter("mes");
		String dia = request.getParameter("dia");
		
		String id_proyecto = request.getParameter("id_pr");
		
		AccesoDatos ad = (AccesoDatos) getServletContext().getAttribute("bd");

		try {			
			ad.creaTarea(nombreTarea, Integer.parseInt(id_proyecto), programador, Integer.parseInt(anyo), Integer.parseInt(mes), Integer.parseInt(dia));
			
			ArrayList<Proyecto> proyectos = ad.getAllProyectos();
			Proyecto proyecto = new Proyecto();
			for(int i = 0; i < proyectos.size(); i++) {
				if(proyectos.get(i).getId() == Integer.parseInt(id_proyecto))
					proyecto = proyectos.get(i);
			}
			request.setAttribute("proyecto", proyecto);
			
			ArrayList<Tarea> tareas = ad.getAllTareas(proyecto.getId());
			
			request.setAttribute("tareas", tareas);

			getServletContext().getRequestDispatcher(
					"/jefeproyecto/muestraTareas.jsp").forward(request,
					response);
		} catch (Exception ex) {
			request.setAttribute("msg",
					"Se ha producido un error interno al crear la tarea");
			getServletContext().getRequestDispatcher("/errorPage.jsp").forward(
					request, response);
		}

	}

}
