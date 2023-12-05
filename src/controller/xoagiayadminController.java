package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.themsuaxoagiaydao;

/**
 * Servlet implementation class xoagiayadminController
 */
@WebServlet("/xoagiayadminController")
public class xoagiayadminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xoagiayadminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("mg") != null) {
			String magiay = request.getParameter("mg");
			themsuaxoagiaydao lbo = new themsuaxoagiaydao();

					try {
						lbo.Xoagiay(magiay);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			RequestDispatcher rd = request.getRequestDispatcher("quanlygiayadminController");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
