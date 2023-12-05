package controller;


import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.giaybean;

import bo.giaybo;
import bo.loaibo;


/**
 * Servlet implementation class htsuagiayController
 */
@WebServlet("/htsuagiayController")
public class htsuagiayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public htsuagiayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loaibo lbo = new loaibo();
		request.setAttribute("dsloai", lbo.getloai());			
		giaybo sbo = new giaybo();
		ArrayList<giaybean> gbean = (ArrayList<giaybean>)sbo.getGiaybyma(request.getParameter("mg"));
		request.setAttribute("giay", gbean);	
		
		RequestDispatcher rd = request.getRequestDispatcher("suagiayadmin.jsp");
		rd.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
