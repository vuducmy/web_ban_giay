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

import bean.loaibean;
import bo.khachangbo;
import bo.loaibo;

/**
 * Servlet implementation class ktdkController
 */
@WebServlet("/ktdkController")
public class ktdkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ktdkController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			loaibo lbo = new loaibo();
			ArrayList<loaibean> dsloai = lbo.getloai();
			request.setAttribute("dsloai", dsloai);
			String username = request.getParameter("tk");
			String pass = request.getParameter("mk");
			String ht = request.getParameter("ht");
			String dc = request.getParameter("dc");
			String sdt = request.getParameter("sdt");
			HttpSession session = request.getSession();
			khachangbo khbo = new khachangbo();
			RequestDispatcher rd = null;
			if (username == null) {
				rd = request.getRequestDispatcher("dangky.jsp");
				rd.forward(request, response);
			} else {
				if (khbo.timTaiKhoan(username) == null) {
					khbo.dangky(ht, dc, sdt, username, khbo.getMd5Hash(pass));
					session.setAttribute("dk", username);
					session.setAttribute("dn", username);
					rd = request.getRequestDispatcher("htgiayController");
				} else
					rd = request.getRequestDispatcher("dangkyController?kt=1");
					rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
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
