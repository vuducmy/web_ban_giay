package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.xacnhanchuyentienbo;

/**
 * Servlet implementation class xacnhanchuyentienController
 */
@WebServlet("/xacnhanchuyentienController")
public class xacnhanchuyentienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacnhanchuyentienController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String ma = request.getParameter("mct");
		if (ma != null) {
			long maa = Long.parseLong(ma);
			xacnhanchuyentienbo xnctbo = new xacnhanchuyentienbo();
			xnctbo.xacnhan(maa);
			RequestDispatcher rd = request.getRequestDispatcher("xacnhanController");
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
