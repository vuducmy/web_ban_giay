package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class giohangController
 */
@WebServlet("/giohangController")
public class giohangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public giohangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String magiay=request.getParameter("mg");
		String tengiay=request.getParameter("tg");
		String anh=request.getParameter("anh");
		long soluong=(long)1;
		long gia=Long.parseLong(request.getParameter("gia"));
		giohangbo gh;
		HttpSession session = request.getSession();
		//Neu mua lan dau
		if(session.getAttribute("gio")==null){
			gh= new giohangbo(); // cap vung nho
			session.setAttribute("gio", gh); // tao sesi
		}
		//b1: gan session vao 1 bien
		gh=(giohangbo) session.getAttribute("gio");
		//b2: Thao tac trên bien: gh
		gh.Them(magiay, tengiay,anh, soluong, gia);
		//b3: Luu gh vao session
		session.setAttribute("gio", gh);
		//Hien thi gio
		response.sendRedirect("htgioController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
