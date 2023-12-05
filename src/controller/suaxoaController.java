package controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class suaxoaController
 */
@WebServlet("/suaxoaController")
public class suaxoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suaxoaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		giohangbo gh;
		//b1: gan session vao 1 bien
		gh = (giohangbo) session.getAttribute("gio");
		if (request.getParameter("butsua") != null) {
			Enumeration<String> d = request.getParameterNames();
			String[] gtcheck = request.getParameterValues("check");
			if (gtcheck != null) {
				while (d.hasMoreElements()) {
			String tendk = d.nextElement();
			for (String ss : gtcheck) {
				if (ss.equals(tendk)) {
					String gt = request.getParameter(tendk);
					gh.Sua(ss, Long.parseLong(gt));
				}

			}
				}
			} else {
				String ms = request.getParameter("butsua");
				long sl = Long.parseLong(request.getParameter(ms));
				gh.Sua(ms, sl);
			}
		}
		if (request.getParameter("butxoa") != null) {
			String[] gtcheck = request.getParameterValues("check");
			//b2: Thao tac trên bien: gh
			if (gtcheck != null) {
				for (String ss : gtcheck)
			gh.Xoa(ss);
			} else {
				String ms = request.getParameter("butxoa");
				gh.Xoa(ms);
			}
		}
		if (request.getParameter("btnxoatatca") != null) {
			//b2: Thao tac trên bien: gh
			gh.XoaAll();
		}
		session.setAttribute("gio", gh);
		if (gh.ds.size() == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("htgiayController");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("htgioController");
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
