package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.lichsumuahangbean;
import bo.khachangbo;
import bo.lichsumuahangbo;

/**
 * Servlet implementation class lichsumuahangController
 */
@WebServlet("/lichsumuahangController")
public class lichsumuahangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lichsumuahangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
 		response.setCharacterEncoding("utf-8");
 		HttpSession session = request.getSession();
 		if (session.getAttribute("dn") == null) {
 			response.sendRedirect("ktdnController");
 		}
 		else {
	 		lichsumuahangbo lsbo = new lichsumuahangbo();
	 		khachangbo khbo = new khachangbo();
	 		String username = (String) session.getAttribute("dn");
	 		ArrayList<lichsumuahangbean> dslsmh = lsbo.getlsmh(khbo.getMakh(username));
			request.setAttribute("dslsmh", dslsmh);
			RequestDispatcher rd = request.getRequestDispatcher("lichsumuahang.jsp");
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
