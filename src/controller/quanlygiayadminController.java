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

/**
 * Servlet implementation class quanlygiayadminController
 */
@WebServlet("/quanlygiayadminController")
public class quanlygiayadminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanlygiayadminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");	    
	    String indexPage = request.getParameter("index");

		if (indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);	
		giaybo sbo = new giaybo();
		ArrayList<giaybean> dsgiay;
		int count = 0;
		int endPage = 0;
			count = sbo.getTotalGiay("");
			endPage = count / 6;
			if (count % 6 != 0) {
				endPage++;
			}     
			
			request.setAttribute("endP", endPage);
			request.setAttribute("index", index);
			dsgiay = sbo.getGiayPag(index);		
			request.setAttribute("dsgiay", dsgiay);
        RequestDispatcher rd = request.getRequestDispatcher("quanlygiayadmin.jsp");
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
