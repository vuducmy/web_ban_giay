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

import bean.khachangbean;
import bean.loaibean;
import bo.khachangbo;
import bo.loaibo;
import nl.captcha.Captcha;

/**
 * Servlet implementation class ktdnController
 */
@WebServlet("/ktdnController")
public class ktdnController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ktdnController() {
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
			String username = request.getParameter("txtun");
			String pass = request.getParameter("txtpass");
			HttpSession session = request.getSession();
			khachangbo khbo = new khachangbo();
			loaibo lbo = new loaibo();
			ArrayList<loaibean> dsloai = lbo.getloai();
			request.setAttribute("dsloai", dsloai);
			ArrayList<khachangbean> dskh = khbo.getkhachhang();
			int count = 0;
			if (session.getAttribute("countLogin") != null)
				count = (int) session.getAttribute("countLogin");
			if (username != null && pass != null) {
				Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
				String answer = request.getParameter("answer");
				if (count >= 3 && captcha.isCorrect(answer)) {
					for (khachangbean item : dskh)
						if (item.getTenDangNhap().toLowerCase().equals(username)
								&& item.getMatKhau().equals(khbo.getMd5Hash(pass))) {
							session.setAttribute("dn", username);
							session.setAttribute("countLogin", 0);
							response.sendRedirect("htgiayController");
						}
				} else if (count < 3) {
					for (khachangbean item : dskh)
						if (item.getTenDangNhap().toLowerCase().equals(username)
								&& item.getMatKhau().equals(khbo.getMd5Hash(pass))) {
							session.setAttribute("dn", username);
							session.setAttribute("countLogin", 0);
							RequestDispatcher rd = request.getRequestDispatcher("htgiayController");
							rd.forward(request, response);
						}
				}

				session.setAttribute("countLogin", count + 1);
				RequestDispatcher rd = request.getRequestDispatcher("dangnhapController?kt=1");
				rd.forward(request, response);
			} else {
				session.setAttribute("countLogin", 0);
				session.removeAttribute("dn");
				RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
				rd.forward(request, response);

			}
		} catch (Exception e) {
			// TODO: handle exception
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
