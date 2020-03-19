package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ApplicationController;
import viewresolver.ViewResolver;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/application/*")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ApplicationController applicationController;
	private ViewResolver viewResolver;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----------------FRONT CONTROLLER DO GET---------------");
		
		
		forwardRequest(request, response);
	}

	private void forwardRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getPathInfo();
		System.out.println(path);
		String view = applicationController.processRequest(request, path);
		System.out.println(view);
		String page = viewResolver.getPage(view);
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----------------FRONT CONTROLLER DO POST---------------");
		forwardRequest(request, response);
	
	}
	
	@Override
	public void init() throws ServletException {
		applicationController = new ApplicationController();
		viewResolver = new ViewResolver();
		
		
	}

}
