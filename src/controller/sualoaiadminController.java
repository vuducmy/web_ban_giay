package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.themsuaxoaloaibo;

/**
 * Servlet implementation class sualoaiadminController
 */
@WebServlet("/sualoaiadminController")
public class sualoaiadminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sualoaiadminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		if(request.getParameter("ml") != null && request.getParameter("txttenloai") != null && !request.getParameter("txttenloai").equals("") ) {
			String maloai = request.getParameter("ml");
			String tenloai = request.getParameter("txttenloai");
			themsuaxoaloaibo lbo = new themsuaxoaloaibo();
			lbo.sualoai(maloai, tenloai);
			response.sendRedirect("quanlyloaiadminController");
		}
		else {
			request.setAttribute("maloai", request.getParameter("ml"));
			request.setAttribute("tenloai", request.getParameter("tenloai"));
			RequestDispatcher rd = request.getRequestDispatcher("sualoaiadmin.jsp");
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
