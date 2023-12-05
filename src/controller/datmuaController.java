package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bo.chitietbo;
import bo.giohangbo;
import bo.hoadonbo;
import bo.khachangbo;

/**
 * Servlet implementation class datmuaController
 */
@WebServlet("/datmuaController")
public class datmuaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public datmuaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		if(session.getAttribute("dn") == null)
			response.sendRedirect("ktdnController");
		else {
			giohangbo gh=(giohangbo)session.getAttribute("gio");
			hoadonbo hdbo= new hoadonbo();
			chitietbo ctbo= new chitietbo();
			String username = (String) session.getAttribute("dn");
			khachangbo khbo = new khachangbo();
			hdbo.Them(khbo.getMakh(username));
			long mahd=hdbo.maxhd();
			for(giohangbean g: gh.ds)
				ctbo.Them(g.getMaGiay(),g.getSoLuong(),mahd);
				session.removeAttribute("gio");
				response.sendRedirect("lichsumuahangController");
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
